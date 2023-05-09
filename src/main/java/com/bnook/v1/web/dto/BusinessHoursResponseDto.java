package com.bnook.v1.web.dto;

import com.bnook.v1.domain.bookstore.BusinessHours;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessHoursResponseDto {

    private LocalTime monOpenTime;
    private LocalTime monCloseTime;
    private LocalTime tueOpenTime;
    private LocalTime tueCloseTime;
    private LocalTime wedOpenTime;
    private LocalTime wedCloseTime;
    private LocalTime thuOpenTime;
    private LocalTime thuCloseTime;
    private LocalTime friOpenTime;
    private LocalTime friCloseTime;
    private LocalTime satOpenTime;
    private LocalTime satCloseTime;
    private LocalTime sunOpenTime;
    private LocalTime sunCloseTime;

}
