package com.bnook.v1.domain.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookstoreRepository extends JpaRepository<Bookstore, Long> {

    @Query("SELECT b FROM Bookstore b ORDER BY b.storeId DESC")
    List<Bookstore> findAllDesc();


}