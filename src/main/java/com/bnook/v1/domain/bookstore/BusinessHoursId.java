package com.bnook.v1.domain.bookstore;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

//@Embeddable
public class BusinessHoursId implements Serializable {
    @Column(name = "id")
    private Long id;

    @Column(name = "day_of_week")
    private String dayOfWeek;
}
