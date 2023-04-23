package com.bnook.v1.config.auth.dto;

import com.bnook.v1.domain.user.Role;
import com.bnook.v1.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private String nameAttributeKey;

    private OAuth2UserInfo oAuth2UserInfo;

    @Builder
    public OAuthAttributes(String nameAttributeKey, OAuth2UserInfo oAuth2UserInfo) {
        this.nameAttributeKey = nameAttributeKey;
        this.oAuth2UserInfo = oAuth2UserInfo;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofKakao(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .nameAttributeKey(userNameAttributeName)
                .oAuth2UserInfo(new KakaoOAuth2UserInfo(attributes))
                .build();
    }

    public User toEntity(int registrationNo, OAuth2UserInfo oAuth2UserInfo) {
        return User.builder()
                .registrationNo(registrationNo)
                .id(oAuth2UserInfo.getId())
                .email(oAuth2UserInfo.getEmail())
                .nickName(oAuth2UserInfo.getNickname())
                .role(Role.USER)
                .build();
    }

}
