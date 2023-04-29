package com.bnook.v1.domain.bookstore;

import com.bnook.v1.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Getter
@NoArgsConstructor
@Entity
public class Bookstore extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID")
    private Long storeId;

    @Column(nullable = false, name = "STORE_NAME")
    private String storeName;

    @Column(name = "OWNER_ONE_WORD")
    private String ownerOneWord;

//    private String ownerName;

    private String address;

    @Column(name = "PHONE_NO")
    private String phoneNo;

    @Column(name = "INSTAGRAM_ID")
    private String instagramId;

    @Column(name = "FACEBOOK_ID")
    private String facebookId;

    @Column(name = "BLOG_ID")
    private String blogId;

    private String website;

    @Column(name = "BUSINESS_DAYS")
    private String businessDays;

    @Column(name = "CLOSE_DAYS")
    private String closeDays;

    @Column(name = "PRGR_CTGR1")
    private String prgrCtgr1;

    @Column(name = "PRGR_CTGR2")
    private String prgrCtgr2;

    @Column(name = "PRGR_CTGR3")
    private String prgrCtgr3;

    @Column(name = "BEVERAGE_YN_CTGR")
    private String beverageYnCtgr;

    @Column(name = "ART_YN_CTGR")
    private String artYnCtgr;

    @Column(name = "PRODUCT_YN_CTGR")
    private String productYnCtgr;

    @Column(name = "INDPN_BOOK_FILTER")
    private String indpnBookFilter;

    @Column(name = "SPCL_BOOK_FILTER")
    private String spclBookFilter;

    @Column(name = "CMPRN_BOOK_FILTER")
    private String cmprnBookFilter;

    @Column(name = "FORGN_BOOK_FILTER")
    private String forgnBookFilter;

    @Builder
    public Bookstore(String storeName, String ownerOneWord, String address, String phoneNo, String instagramId, String facebookId, String blogId, String website, String businessDays, String closeDays, String prgrCtgr1, String prgrCtgr2, String prgrCtgr3, String beverageYnCtgr, String artYnCtgr, String productYnCtgr, String indpnBookFilter, String spclBookFilter, String cmprnBookFilter, String forgnBookFilter) {
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

    public void update(String storeName, String ownerOneWord, String address, String phoneNo, String instagramId, String facebookId, String blogId, String website, String businessDays, String closeDays, String prgrCtgr1, String prgrCtgr2, String prgrCtgr3, String beverageYnCtgr, String artYnCtgr, String productYnCtgr, String indpnBookFilter, String spclBookFilter, String cmprnBookFilter, String forgnBookFilter) {
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
}
