package com.bnook.v1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookstoreUpdateRequestDto {

    private Long storeId;
    private String storeName;
    private String ownerOneWord;
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

    @Builder
    public BookstoreUpdateRequestDto(String storeName, String ownerOneWord, String address, String phoneNo, String instagramId, String facebookId, String blogId, String website, String businessDays, String closeDays, String prgrCtgr1, String prgrCtgr2, String prgrCtgr3, String beverageYnCtgr, String artYnCtgr, String productYnCtgr, String indpnBookFilter, String spclBookFilter, String cmprnBookFilter, String forgnBookFilter) {
        this.storeName = storeName;
        this.ownerOneWord = ownerOneWord;
        this.address = address;
        this.phoneNo = phoneNo;
        this.instagramId = instagramId;
        this.facebookId = facebookId;
        this.blogId = blogId;
        this.website = website;
        this.businessDays = businessDays;
        this.closeDays = closeDays;
        this.prgrCtgr1 = prgrCtgr1;
        this.prgrCtgr2 = prgrCtgr2;
        this.prgrCtgr3 = prgrCtgr3;
        this.beverageYnCtgr = beverageYnCtgr;
        this.artYnCtgr = artYnCtgr;
        this.productYnCtgr = productYnCtgr;
        this.indpnBookFilter = indpnBookFilter;
        this.spclBookFilter = spclBookFilter;
        this.cmprnBookFilter = cmprnBookFilter;
        this.forgnBookFilter = forgnBookFilter;
    }

}
