package com.bnook.v1.domain.user;

import lombok.Getter;

import java.io.Serializable;

/**
 * @desc: userId의 복합키 설정을 위한 클래스
 */

@Getter
public class UserId implements Serializable {

    private int registrationNo;
    private String id;

    public UserId() {
    }

    public UserId(int registrationNo, String id) {
        this.registrationNo = registrationNo;
        this.id = id;
    }
}
