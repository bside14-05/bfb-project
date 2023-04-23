package com.bnook.v1.web.user.dto;

import com.bnook.v1.domain.bookstore.Bookstore;
import com.bnook.v1.domain.user.User;
import com.bnook.v1.web.dto.BookstoreResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class UserResponseDto {
    private String email;
    private String nickName;

    private List<BookstoreResponseDto> myBookstores;

    @Builder
    public UserResponseDto(String email, String nickName) {
        this.nickName = nickName;
    }

    public UserResponseDto(User user) {
        this.email = user.getEmail();
        this.nickName = user.getNickName();
    }
}
