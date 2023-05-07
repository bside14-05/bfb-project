package com.bnook.v1.domain.bookstore;

import com.bnook.v1.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@DynamicUpdate
@Getter
@NoArgsConstructor
@Entity
public class Bookstore extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookstore_id")
    private Long bookstoreId;

    @Column(nullable = false, name = "bookstore_name")
    private String bookstoreName;

    @Column(name = "owner_comment")
    private String ownerComment;

    private String address;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "instagram_id")
    private String instagramId;

    @Column(name = "facebook_id")
    private String facebookId;

    @Column(name = "blog_id")
    private String blogId;

    private String website;

    @Column(name = "program_category1")
    private String programCategory1;

    @Column(name = "program_category2")
    private String programCategory2;

    @Column(name = "program_category3")
    private String programCategory3;

    @Column(name = "is_beverage_alcohol")
    private boolean isBeverageAlcohol;

    @Column(name = "is_art_exhibition")
    private boolean isArtExhibition;

    @Column(name = "is_merchandise_sale")
    private boolean isMerchandiseSale;

    @Column(name = "is_program_operating")
    private boolean isProgramOperating;

    @Column(name = "is_other")
    private boolean isOther;

    @Column(name = "has_indie_book")
    private boolean hasIndieBook;

    @Column(name = "has_specialized_book")
    private boolean hasSpecializedBook;

    @Column(name = "has_comprehensive_book")
    private boolean hasComprehensiveBook;

    @Column(name = "has_foreign_book")
    private boolean hasForeignBook;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bookstore_id")
    private List<BusinessHours> businessHours;

    public boolean isHasSpecializedBook() {
        return hasSpecializedBook;
    }

    public boolean isHasComprehensiveBook() {
        return hasComprehensiveBook;
    }

    @Builder
    public Bookstore(String bookstoreName, String ownerComment, String address, String phoneNo, String instagramId, String facebookId, String blogId, String website, String programCategory1, String programCategory2, String programCategory3, boolean isBeverageAlcohol, boolean isArtExhibition, boolean isMerchandiseSale, boolean isProgramOperating, boolean isOther, boolean hasIndieBook, boolean hasSpecializedBook, boolean hasComprehensiveBook, boolean hasForeignBook) {
        this.bookstoreName = bookstoreName;
        this.ownerComment = ownerComment;
        this.address = address;
        this.phoneNo = phoneNo;
        this.instagramId = instagramId;
        this.facebookId = facebookId;
        this.blogId = blogId;
        this.website = website;
        this.programCategory1 = programCategory1;
        this.programCategory2 = programCategory2;
        this.programCategory3 = programCategory3;
        this.isBeverageAlcohol = isBeverageAlcohol;
        this.isArtExhibition = isArtExhibition;
        this.isMerchandiseSale = isMerchandiseSale;
        this.isProgramOperating = isProgramOperating;
        this.isOther = isOther;
        this.hasIndieBook = hasIndieBook;
        this.hasSpecializedBook = hasSpecializedBook;
        this.hasComprehensiveBook = hasComprehensiveBook;
        this.hasForeignBook = hasForeignBook;
    }

    public void update(String bookstoreName, String ownerComment, String address, String phoneNo, String instagramId, String facebookId, String blogId, String website, String programCategory1, String programCategory2, String programCategory3, boolean isBeverageAlcohol, boolean isArtExhibition, boolean isMerchandiseSale, boolean isProgramOperating, boolean isOther, boolean hasIndieBook, boolean hasSpecializedBook, boolean hasComprehensiveBook, boolean hasForeignBook) {
        this.bookstoreName = bookstoreName;
        this.ownerComment = ownerComment;
        this.address = address;
        this.phoneNo = phoneNo;
        this.instagramId = instagramId;
        this.facebookId = facebookId;
        this.blogId = blogId;
        this.website = website;
        this.programCategory1 = programCategory1;
        this.programCategory2 = programCategory2;
        this.programCategory3 = programCategory3;
        this.isBeverageAlcohol = isBeverageAlcohol;
        this.isArtExhibition = isArtExhibition;
        this.isMerchandiseSale = isMerchandiseSale;
        this.isProgramOperating = isProgramOperating;
        this.isOther = isOther;
        this.hasIndieBook = hasIndieBook;
        this.hasSpecializedBook = hasSpecializedBook;
        this.hasComprehensiveBook = hasComprehensiveBook;
        this.hasForeignBook = hasForeignBook;
    }
}

