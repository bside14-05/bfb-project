package com.bnook.v1.domain.user;

import com.bnook.v1.domain.BaseEntity;
import com.bnook.v1.domain.bookstore.Bookstore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 사용자 정보를 저장하는 Entity
 */
@Getter
@NoArgsConstructor
@IdClass(UserId.class)
@Entity
public class User extends BaseEntity {

    @Id
    private int registrationNo;
    @Id
    private String id;
    private String email;
    private String nickName;

    private String refreshToken;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Bookstore> myBookstores = new ArrayList<>();

    @Builder
    public User(int registrationNo, String id, String email, String nickName, Role role) {
        this.registrationNo = registrationNo;
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.role = role;
    }

    public User update(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public void authorizeUser() {
        this.role = Role.USER;
    }

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }

}
