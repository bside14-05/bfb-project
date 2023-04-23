package com.bnook.v1.config.auth.service;

import com.bnook.v1.config.auth.dto.CustomOAuth2User;
import com.bnook.v1.config.auth.dto.OAuth2UserInfo;
import com.bnook.v1.config.auth.dto.OAuthAttributes;
import com.bnook.v1.domain.user.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * @desc: 로그인 이후 가져온 사용자 정보를 기반으로 가입 및 정보 수정, 세션 저장 등의 기능을 지원하는 클래스
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;

    private static final String KAKAO = "kakao";

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("### CustomOAuth2UserService.loadUser ---");

        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();
        Map<String, Object> attributes = oAuth2User.getAttributes();
        OAuthAttributes extractAttributes = OAuthAttributes.of(registrationId, userNameAttributeName, attributes);

        User user = saveOrUpdate(extractAttributes, registrationId);

        return new CustomOAuth2User(Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRoleKey()))
                , attributes
                , extractAttributes.getNameAttributeKey()
                , user.getRole());
    }

    private User saveOrUpdate(OAuthAttributes attributes, String registrationId) {
        OAuth2UserInfo userInfo = attributes.getOAuth2UserInfo();
        int registrationNo = Optional.ofNullable(Provider.valueOf(registrationId.toUpperCase()).getRegistrationNo()).orElse(0);

        User user = userRepository.findByUserId(new UserId(registrationNo, userInfo.getId()))
                .map(entity -> entity.update(userInfo.getEmail(), userInfo.getNickname()))
                .orElse(attributes.toEntity(registrationNo, userInfo));

        return userRepository.save(user);
    }
}
