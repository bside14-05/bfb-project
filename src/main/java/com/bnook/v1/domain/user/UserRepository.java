package com.bnook.v1.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserId> {

    @Query("SELECT u FROM User u WHERE u.registrationNo = :#{#userId.registrationNo} AND u.id = :#{#userId.id}")
    Optional<User> findByUserId(UserId userId);

    @Query("SELECT u FROM User u WHERE u.email = :#{#email}")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.refreshToken = :#{#refreshToken}")
    Optional<User> findByRefreshToken(String refreshToken);

//    Optional<User> findLikedBookstores(String email);
}
