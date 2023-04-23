package com.bnook.v1.domain.user;

import com.bnook.v1.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(int registrationNo, String id, String email, String nickName, Role role) {
        this.registrationNo = registrationNo;
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.role = role;
    }

    public User update(String email, String nickName) {
        this.email = email;
        this.nickName = nickName;
        return this;
    }

    public String getRoleKey() {
        return this.role.getRoleKey();
    }

}
