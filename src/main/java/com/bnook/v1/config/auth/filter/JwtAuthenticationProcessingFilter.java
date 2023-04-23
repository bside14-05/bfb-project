package com.bnook.v1.config.auth.filter;

import com.bnook.v1.config.auth.dto.Constants;
import com.bnook.v1.config.auth.service.JwtService;
import com.bnook.v1.domain.user.User;
import com.bnook.v1.domain.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 클라이언트가 헤더에 JWT 토큰을 담아서 "/login" URL 이외의 요청을 보냈을 시
 * 해당 토큰들의 유효성을 검사하여 인증 처리/인증 실패/토큰 재발급 등을 수행하는 역할의 필터
 *
 * 기본적으로 사용자는 요청 헤더에 AccessToken만 담아서 요청
 * AccessToken 만료 시에만 RefreshToken을 요청 헤더에 AccessToken과 함께 요청
 *
 * 1. RefreshToken이 없고, AccessToken이 유효한 경우 -> 인증 성공 처리, RefreshToken을 재발급하지는 않는다.
 * 2. RefreshToken이 없고, AccessToken이 없거나 유효하지 않은 경우 -> 인증 실패 처리, 403 ERROR
 * 3. RefreshToken이 있는 경우 -> DB의 RefreshToken과 비교하여 일치하면 AccessToken 재발급, RefreshToken 재발급(RTR 방식)
 *                             인증 성공 처리는 하지 않고 실패 처리
 */
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationProcessingFilter extends OncePerRequestFilter {

    private static final String WHITELIST_URL = "/login";

    private final JwtService jwtService;
    private final UserRepository userRepository;

    private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().equals(WHITELIST_URL)) {
            filterChain.doFilter(request, response);
            return;
        }

        String refreshToken = jwtService.extractToken(request, Constants.REFRESH_TOKEN_SUBJECT)
                .filter(jwtService::validateToken)
                .orElse(null);

        if (refreshToken != null) {
            checkRefreshTokenAndReIssueAccessToken(response, refreshToken);
        } else {
            checkAccessTokenAndAuthentication(request, response, filterChain);
        }
    }

    protected void checkRefreshTokenAndReIssueAccessToken(HttpServletResponse response, String refreshToken) {
        userRepository.findByRefreshToken(refreshToken)
                .ifPresent(user -> {
                    String newRefreshToken = reIssueRefreshToken(user);
                    jwtService.sendToken(response, jwtService.createAccessToken(user.getEmail()), newRefreshToken);
                });
    }

    private String reIssueRefreshToken(User user) {
        String newRefreshToken = jwtService.createRefreshToken();
        user.updateRefreshToken(newRefreshToken);
        userRepository.save(user);
        return newRefreshToken;
    }
    protected void checkAccessTokenAndAuthentication(HttpServletRequest request, HttpServletResponse response,
                                                     FilterChain filterChain) throws ServletException, IOException {
        jwtService.extractToken(request, Constants.ACCESS_TOKEN_SUBJECT)
                .filter(jwtService::validateToken)
                .ifPresent(accessToken -> jwtService.extractEmail(accessToken)
                        .ifPresent(email-> userRepository.findByEmail(email)
                                .ifPresent(this::saveAuthentication))
                );
        filterChain.doFilter(request, response);
    }

    private void saveAuthentication(User user) {
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(generateSecurePassword())
                .roles(user.getRole().name())
                .build();

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                authoritiesMapper.mapAuthorities(userDetails.getAuthorities()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String generateSecurePassword(){
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(
                8, new CharacterRule(EnglishCharacterData.LowerCase), new CharacterRule(EnglishCharacterData.Digit));
        return password;
    }
}
