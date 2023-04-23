package com.bnook.v1.config.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

//@Configuration
//public class OAuth2LoginConfig {
//
//    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
//    private String clientId;
//    @Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
//    private String clientSecret;
//    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
//    private String redirectUri;
//    @Value("${spring.security.oauth2.client.registration.kakao.authorization-grant-type}")
//    private AuthorizationGrantType authorizationGrantType;
//    @Value("${spring.security.oauth2.client.registration.kakao.scope}")
//    private String scope;
//    @Value("${spring.security.oauth2.client.registration.kakao.client-authentication-method}")
//    private ClientAuthenticationMethod clientAuthenticationMethod;
//    @Value("${spring.security.oauth2.provider.kakao.authorization-uri}")
//    private String authorizationUri;
//    @Value("${spring.security.oauth2.provider.kakao.token-uri}")
//    private String tokenUri;
//    @Value("${spring.security.oauth2.provider.kakao.user-info-uri}")
//    private String userInfoUri;
//    @Value("${spring.security.oauth2.provider.kakao.user-name-attribute}")
//    private String userNameAttribute;
//
//
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        return new InMemoryClientRegistrationRepository(this.kakaoClientRegistration());
//    }
//
//    private ClientRegistration kakaoClientRegistration() {
//        return ClientRegistration.withRegistrationId("kakao")
//                .clientId(clientId)
//                .clientSecret(clientSecret)
//                .clientAuthenticationMethod(clientAuthenticationMethod)
//                .authorizationGrantType(authorizationGrantType)
//                .redirectUri(redirectUri)
//                .scope(scope)
//                .authorizationUri(authorizationUri)
//                .tokenUri(tokenUri)
//                .userInfoUri(userInfoUri)
//                .userNameAttributeName(userNameAttribute)
//                .build();
//    }
//
//}
