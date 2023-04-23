package com.bnook.v1.web.user.dto;

import com.bnook.v1.domain.bookstore.Bookstore;
import com.bnook.v1.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String id;
    private String email;
    private String nickName;
    private Bookstore bookstore;
//    private FavoriteTestResult favoriteTestResult;  // Enum or Entity로 관리

    @Builder
    public UserSaveRequestDto(String nickName, Bookstore bookstore) {
        this.nickName = nickName;
        this.bookstore = bookstore;
    }
    public User toEntity() {
        return User.builder()
                .email(email)
                .nickName(nickName)
                .build();
    }

    public void likeBookstore(Bookstore bookstore) {

    }
}
