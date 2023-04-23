package com.bnook.v1.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @desc: 사용자 권한을 관리하는 Enum 클래스
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST"), USER("ROLE_USER");
    private final String roleKey;

    public String getRoleKey() {
        return roleKey;
    }
}
