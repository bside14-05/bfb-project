package com.bnook.v1.config.auth.config;

import com.bnook.v1.config.auth.filter.JwtAuthenticationProcessingFilter;
import com.bnook.v1.config.auth.handler.OAuth2LoginFailureHandler;
import com.bnook.v1.config.auth.handler.OAuth2LoginSuccessHandler;
import com.bnook.v1.config.auth.service.CustomOAuth2UserService;
import com.bnook.v1.config.auth.service.JwtService;
import com.bnook.v1.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @desc: 스프링 시큐리티 관련 설정을 담는 클래스
 */
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
    private final OAuth2LoginFailureHandler oAuth2LoginFailureHandler;

    //     HttpSessionOAuth2AuthorizationRequestRepository의 대신?
//    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;
//    private final CustomUserDetailsService customUserDetailsService;

    private static final String [] WHITELIST_URI = {
            "/**", "/images/**", "/js/**", "/webjars/**", "/css/**", "/h2-console/**", "/v3/api-docs/**", "/swagger-ui/**", "/login**", "/error**"
    };

    @Bean
    public JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter() {
        return new JwtAuthenticationProcessingFilter(jwtService, userRepository);
    }

    /**
     * Spring Security 5.7버전 이상부터는 Spring Security의 설정 시 설정 메소드를 @Bean을 통해 빈으로 등록해서 컨테이너가 관리하도록 사용
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(authz -> authz
                            .requestMatchers(WHITELIST_URI).permitAll()
//                            .requestMatchers("/api/v1/**").hasAnyRole(Role.USER.name())
                            .anyRequest().authenticated())
                .oauth2Login()
                    .userInfoEndpoint().userService(customOAuth2UserService)
                .and()
                    .successHandler(oAuth2LoginSuccessHandler)
                    .failureHandler(oAuth2LoginFailureHandler)
                .and().logout().invalidateHttpSession(true).clearAuthentication(true).logoutSuccessUrl("/login?logout")
                ;

//        http.addFilterBefore(jwtAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
