package com.bnook.v1.config.auth;

import com.bnook.v1.config.auth.service.CustomOAuth2UserService;
import com.bnook.v1.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * @desc: 스프링 시큐리티 관련 설정을 담는 클래스
 */
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    /**
     * Spring Security 5.7버전 이상부터는 Spring Security의 설정 시 설정 메소드를 @Bean을 통해 빈으로 등록해서 컨테이너가 관리하도록 사용
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(authz -> authz
                            .requestMatchers("/", "/login/**").permitAll()
                            .requestMatchers("/api/v1/**").hasAnyRole(Role.USER.name())
                            .anyRequest().authenticated())
                .oauth2Login(conf ->conf.userInfoEndpoint().userService(customOAuth2UserService))
//                .successHandler()
//                .failureHandler()
                ;

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**", "/css/**")
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }

}
