package com.bnook.v1.config.auth.service;


import com.auth0.jwt.algorithms.Algorithm;
import com.bnook.v1.config.auth.dto.Constants;
import com.bnook.v1.domain.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Slf4j
@Getter
@RequiredArgsConstructor
@Service
public class JwtService {

    @Value("${jwt.secretKey")
    private String secretKey;

    @Value("${jwt.access.expiration}")
    private Long accessTokenExpirationPeriod;

    @Value("${jwt.refresh.expiration}")
    private Long refreshTokenExpirationPeriod;

    @Value("${jwt.access.header}")
    private String accessHeader;

    @Value("${jwt.refresh.header}")
    private String refreshHeader;

    private static final String EMAIL_CLAIM = "email";
    private static final String BEARER = "Bearer ";

    private final UserRepository userRepository;

    public String createAccessToken(String email) {
        Date now = new Date();
        return com.auth0.jwt.JWT.create()
                // Payload 생성
                .withSubject(Constants.REFRESH_TOKEN_SUBJECT)
                .withExpiresAt(new Date(now.getTime() + refreshTokenExpirationPeriod))

                // Claim
                .withClaim(EMAIL_CLAIM, email)

                // HMAC512 알고리즘 사용
                .sign(Algorithm.HMAC512(secretKey));
    }

    public String createRefreshToken() {
        Date now = new Date();
        return com.auth0.jwt.JWT.create()
                .withSubject(Constants.REFRESH_TOKEN_SUBJECT)
                .withExpiresAt(new Date(now.getTime() + refreshTokenExpirationPeriod))
                .sign(Algorithm.HMAC512(secretKey));
    }

    public void sendToken(HttpServletResponse response, String accessToken) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader(accessHeader, accessToken);
    }

    public void sendToken(HttpServletResponse response, String accessToken, String refreshToken) {
        this.sendToken(response, accessToken);
        response.setHeader(refreshHeader, refreshToken);
    }

    public Optional<String> extractToken(HttpServletRequest request, String header) {
        return Optional.ofNullable(request.getHeader(header))
                .filter(token -> token.startsWith(BEARER))
                .map(token -> token.replace(BEARER, ""));
    }

    public Optional<String> extractEmail(String accessToken) {
        try {
            return Optional.ofNullable(com.auth0.jwt.JWT.require(Algorithm.HMAC512(secretKey))
                    .build()
                    .verify(accessToken)
                    .getClaim(EMAIL_CLAIM)
                    .asString());
        } catch (Exception e) {
            log.error("Invalid Access Token Error!! {}", e.getMessage());
            return Optional.empty();
        }
    }

    public void updateRefreshToken(String email, String refreshToken) {
        userRepository.findByEmail(email)
                .ifPresentOrElse(
                    user -> user.updateRefreshToken(refreshToken),
                    () -> new Exception("일치하는 회원이 없습니다.")
                );
    }

    public boolean validateToken(String token) {
        try {
            com.auth0.jwt.JWT.require(Algorithm.HMAC512(secretKey)).build().verify(token);
            return true;
        } catch (Exception e) {
            log.error("Invalid Access Token Error!! {}", e.getMessage());
            return false;
        }
    }

}
