package com.bnook.v1.domain.bookstore;

import com.bnook.v1.web.dto.BookstoreResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BookstoreRepository extends JpaRepository<Bookstore, Long> {

    @Query("SELECT b FROM Bookstore b ORDER BY b.bookstoreId DESC")
    List<Bookstore> findAllDesc();

    @Query("SELECT new com.bnook.v1.web.dto.BookstoreResponseDto(b, bh) " +
            "FROM Bookstore b LEFT OUTER JOIN b.businessHours bh " +
            "ON b.bookstoreId = bh.businessHoursId " +
            "WHERE b.bookstoreId = :bookstoreId"
    )
    BookstoreResponseDto getBookstoreJoinedBusinessHours(@Param("bookstoreId") Long bookstoreId);


}