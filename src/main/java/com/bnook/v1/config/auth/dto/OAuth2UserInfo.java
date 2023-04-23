package com.bnook.v1.config.auth.dto;

import java.util.Map;

public abstract class OAuth2UserInfo {

    protected Map<String, Object> attributes;

    public OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public abstract String getId();  // kakao: "id"
    public abstract String getEmail();
    public abstract String getNickname();

}
