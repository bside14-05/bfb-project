package com.bnook.v1.web.dto;

import com.bnook.v1.domain.bookstore.Bookstore;
import com.bnook.v1.domain.bookstore.BusinessHours;
import com.bnook.v1.domain.bookstore.BusinessHours_listVer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Optional;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookstoreResponseDto {
    private Long bookstoreId;
    private String bookstoreName;
    private String ownerComment;
    private String address;
    private String phoneNo;
    private String instagramId;
    private String facebookId;
    private String blogId;
    private String website;
    private String programCategory1;
    private String programCategory2;
    private String programCategory3;
    private String isBeverageAlcohol;
    private String isArtExhibition;
    private String isMerchandiseSale;
    private String isProgramOperating;
    private String isOther;
    private String hasIndieBook;
    private String hasSpecializedBook;
    private String hasComprehensiveBook;
    private String hasForeignBook;

//    private Optional<BusinessHoursResponseDto> businessHours;

//    private LocalTime monOpenTime;
//    private LocalTime monCloseTime;
//    private LocalTime tueOpenTime;
//    private LocalTime tueCloseTime;
//    private LocalTime wedOpenTime;
//    private LocalTime wedCloseTime;
//    private LocalTime thuOpenTime;
//    private LocalTime thuCloseTime;
//    private LocalTime friOpenTime;
//    private LocalTime friCloseTime;
//    private LocalTime satOpenTime;
//    private LocalTime satCloseTime;
//    private LocalTime sunOpenTime;
//    private LocalTime sunCloseTime;

    public BookstoreResponseDto(Bookstore bookstore, BusinessHours businessHours) {
        this.bookstoreId = bookstore.getBookstoreId();
        this.bookstoreName = bookstore.getBookstoreName();
        this.ownerComment = bookstore.getOwnerComment();
        this.address = bookstore.getAddress();
        this.phoneNo = bookstore.getPhoneNo();
        this.instagramId = bookstore.getInstagramId();
        this.facebookId = bookstore.getFacebookId();
        this.blogId = bookstore.getBlogId();
        this.website = bookstore.getWebsite();
        this.programCategory1 = bookstore.getProgramCategory1();
        this.programCategory2 = bookstore.getProgramCategory2();
        this.programCategory3 = bookstore.getProgramCategory3();
        this.isBeverageAlcohol = bookstore.getIsBeverageAlcohol();
        this.isBeverageAlcohol = bookstore.getIsBeverageAlcohol();
        this.isArtExhibition = bookstore.getIsArtExhibition();
        this.isMerchandiseSale = bookstore.getIsMerchandiseSale();
        this.isProgramOperating = bookstore.getIsProgramOperating();
        this.isOther = bookstore.getIsOther();
        this.hasIndieBook = bookstore.getHasIndieBook();
        this.hasComprehensiveBook = bookstore.getHasComprehensiveBook();
        this.hasSpecializedBook = bookstore.getHasSpecializedBook();
        this.hasForeignBook = bookstore.getHasForeignBook();

//        this.businessHours = Optional.ofNullable(businessHours)
//                .map(BusinessHoursResponseDto::new);

//        this.monOpenTime = businessHours.getMonOpenTime();
//        this.monCloseTime = businessHours.getMonCloseTime();
//        this.tueOpenTime = businessHours.getTueOpenTime();
//        this.tueCloseTime = businessHours.getTueCloseTime();
//        this.wedOpenTime = businessHours.getWedOpenTime();
//        this.wedCloseTime = businessHours.getWedCloseTime();
//        this.thuOpenTime = businessHours.getThuOpenTime();
//        this.thuCloseTime = businessHours.getThuCloseTime();
//        this.friOpenTime = businessHours.getFriOpenTime();
//        this.friCloseTime = businessHours.getFriCloseTime();
//        this.satOpenTime = businessHours.getSatOpenTime();
//        this.satCloseTime = businessHours.getSatCloseTime();
//        this.sunOpenTime = businessHours.getSunOpenTime();
//        this.sunCloseTime = businessHours.getSunCloseTime();
    }

}
