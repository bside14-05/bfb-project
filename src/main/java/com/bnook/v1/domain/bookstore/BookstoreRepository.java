package com.bnook.v1.domain.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookstoreRepository extends JpaRepository<Bookstore, Long> {

    @Query("SELECT b FROM Bookstore b ORDER BY b.bookstoreId DESC")
    List<Bookstore> findAllDesc();

    @Query("SELECT b FROM Bookstore b LEFT OUTER JOIN b.businessHoursList h " +
            "ON b.bookstoreId = h.businessHoursId.id " +
            "WHERE b.bookstoreId = :bookstoreId")
    Bookstore findBookstoreBusinessHours(@Param("bookstoreId") Long bookstoreId);

}