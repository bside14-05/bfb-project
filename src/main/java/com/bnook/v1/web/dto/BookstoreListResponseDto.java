package com.bnook.v1.web.dto;

import com.bnook.v1.domain.bookstore.Bookstore;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class BookstoreListResponseDto {
    private Long storeId;
    private String storeName;
    private String ownerOneWord;
//    private String ownerName;
    private String address;
    private String phoneNo;
    private String instagramId;
    private String facebookId;
    private String blogId;
    private String website;
    private String businessDays;
    private String closeDays;
    private String prgrCtgr1;
    private String prgrCtgr2;
    private String prgrCtgr3;
    private String beverageYnCtgr;
    private String artYnCtgr;
    private String productYnCtgr;
    private String indpnBookFilter;
    private String spclBookFilter;
    private String cmprnBookFilter;
    private String forgnBookFilter;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public BookstoreListResponseDto(Bookstore entity) {
        this.storeName = entity.getStoreName();
        this.ownerOneWord = entity.getOwnerOneWord();
        this.address = entity.getAddress();
        this.phoneNo = entity.getPhoneNo();
        this.instagramId = entity.getInstagramId();
        this.facebookId = entity.getFacebookId();
        this.blogId = entity.getBlogId();
        this.website = entity.getWebsite();
        this.businessDays = entity.getBusinessDays();
        this.closeDays = entity.getCloseDays();
        this.prgrCtgr1 = entity.getPrgrCtgr1();
        this.prgrCtgr2 = entity.getPrgrCtgr2();
        this.prgrCtgr3 = entity.getPrgrCtgr3();
        this.beverageYnCtgr = entity.getBeverageYnCtgr();
        this.artYnCtgr = entity.getArtYnCtgr();
        this.productYnCtgr = entity.getProductYnCtgr();
        this.indpnBookFilter = entity.getIndpnBookFilter();
        this.spclBookFilter = entity.getSpclBookFilter();
        this.cmprnBookFilter = entity.getCmprnBookFilter();
        this.forgnBookFilter = entity.getForgnBookFilter();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
