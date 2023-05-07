package com.bnook.v1.web.dto;

import com.bnook.v1.domain.bookstore.Bookstore;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class BookstoreListResponseDto {
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
    private boolean isBeverageAlcohol;
    private boolean isArtExhibition;
    private boolean isMerchandiseSale;
    private boolean isProgramOperating;
    private boolean isOther;
    private boolean hasIndieBook;
    private boolean hasSpecializedBook;
    private boolean hasComprehensiveBook;
    private boolean hasForeignBook;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BookstoreListResponseDto(Bookstore entity) {
        this.bookstoreId = entity.getBookstoreId();
        this.bookstoreName = entity.getBookstoreName();
        this.ownerComment = entity.getOwnerComment();
        this.address = entity.getAddress();
        this.phoneNo = entity.getPhoneNo();
        this.instagramId = entity.getInstagramId();
        this.facebookId = entity.getFacebookId();
        this.blogId = entity.getBlogId();
        this.website = entity.getWebsite();
        this.programCategory1 = entity.getProgramCategory1();
        this.programCategory2 = entity.getProgramCategory2();
        this.programCategory3 = entity.getProgramCategory3();
        this.isBeverageAlcohol = entity.isBeverageAlcohol();
        this.isArtExhibition = entity.isArtExhibition();
        this.isMerchandiseSale = entity.isMerchandiseSale();
        this.isProgramOperating = entity.isProgramOperating();
        this.isOther = entity.isOther();
        this.hasIndieBook = entity.isHasIndieBook();
        this.hasComprehensiveBook = entity.isHasComprehensiveBook();
        this.hasComprehensiveBook = entity.isHasComprehensiveBook();
        this.hasForeignBook = entity.isHasForeignBook();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
