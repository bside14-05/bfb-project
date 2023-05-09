package com.bnook.v1.domain.bookstore;

import com.bnook.v1.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "business_hours")
public class BusinessHours extends BaseEntity {

    @Id
    @Column(name = "business_hours_id")
    private Long businessHoursId;

    @Column(name = "mon_open_time")
    private LocalTime monOpenTime;

    @Column(name = "mon_close_time")
    private LocalTime monCloseTime;

    @Column(name = "tue_open_time")
    private LocalTime tueOpenTime;

    @Column(name = "tue_close_time")
    private LocalTime tueCloseTime;

    @Column(name = "wed_open_time")
    private LocalTime wedOpenTime;

    @Column(name = "wed_close_time")
    private LocalTime wedCloseTime;

    @Column(name = "thu_open_time")
    private LocalTime thuOpenTime;

    @Column(name = "thu_close_time")
    private LocalTime thuCloseTime;

    @Column(name = "fri_open_time")
    private LocalTime friOpenTime;

    @Column(name = "fri_close_time")
    private LocalTime friCloseTime;

    @Column(name = "sat_open_time")
    private LocalTime satOpenTime;

    @Column(name = "sat_close_time")
    private LocalTime satCloseTime;

    @Column(name = "sun_open_time")
    private LocalTime sunOpenTime;

    @Column(name = "sun_close_time")
    private LocalTime sunCloseTime;

    @OneToOne(mappedBy = "businessHours", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bookstore bookstore;

    @Builder
    public BusinessHours(LocalTime monOpenTime, LocalTime monCloseTime, LocalTime tueOpenTime, LocalTime tueCloseTime, LocalTime wedOpenTime, LocalTime wedCloseTime, LocalTime thuOpenTime, LocalTime thuCloseTime, LocalTime friOpenTime, LocalTime friCloseTime, LocalTime satOpenTime, LocalTime satCloseTime, LocalTime sunOpenTime, LocalTime sunCloseTime, Bookstore bookstore) {
        this.monOpenTime = monOpenTime;
        this.monCloseTime = monCloseTime;
        this.tueOpenTime = tueOpenTime;
        this.tueCloseTime = tueCloseTime;
        this.wedOpenTime = wedOpenTime;
        this.wedCloseTime = wedCloseTime;
        this.thuOpenTime = thuOpenTime;
        this.thuCloseTime = thuCloseTime;
        this.friOpenTime = friOpenTime;
        this.friCloseTime = friCloseTime;
        this.satOpenTime = satOpenTime;
        this.satCloseTime = satCloseTime;
        this.sunOpenTime = sunOpenTime;
        this.sunCloseTime = sunCloseTime;
        this.bookstore = bookstore;
    }
}
