package com.bnook.v1.web.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String email;
    private String nickName;

    @Builder
    public UserUpdateRequestDto(String nickName) {
        this.nickName = nickName;
    }

}
