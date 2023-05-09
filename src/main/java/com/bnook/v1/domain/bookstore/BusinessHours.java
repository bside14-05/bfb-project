package com.bnook.v1.domain.bookstore;

import com.bnook.v1.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "business_hours")
public class BusinessHours {

    @EmbeddedId
    private BusinessHoursId businessHoursId;

    @Column(name = "open_time")
    private LocalTime openTime;

    @Column(name = "close_time")
    private LocalTime closeTime;

//    @ManyToOne
//    @JoinColumn(name = "bookstore_id", referencedColumnName = "bookstore_id")
//    private Bookstore bookstore;

}
