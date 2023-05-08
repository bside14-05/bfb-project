package com.bnook.v1.web.dto;

import com.bnook.v1.domain.bookstore.Bookstore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BookstoreRequestDto {
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
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public BookstoreRequestDto(String bookstoreName, String ownerComment, String address, String phoneNo, String instagramId, String facebookId, String blogId, String website, String programCategory1, String programCategory2, String programCategory3, String isBeverageAlcohol, String isArtExhibition, String isMerchandiseSale, String isProgramOperating, String isOther, String hasIndieBook, String hasSpecializedBook, String hasComprehensiveBook, String hasForeignBook) {
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

    public Bookstore toEntity() {
        return Bookstore.builder()
                .bookstoreName(bookstoreName)
                .ownerComment(ownerComment)
                .address(address)
                .phoneNo(phoneNo)
                .instagramId(instagramId)
                .facebookId(facebookId)
                .blogId(blogId)
                .website(website)
                .programCategory1(programCategory1)
                .programCategory2(programCategory2)
                .programCategory3(programCategory3)
                .isBeverageAlcohol(isBeverageAlcohol)
                .isArtExhibition(isArtExhibition)
                .isMerchandiseSale(isMerchandiseSale)
                .isProgramOperating(isProgramOperating)
                .isOther(isOther)
                .hasIndieBook(hasIndieBook)
                .hasSpecializedBook(hasSpecializedBook)
                .hasComprehensiveBook(hasComprehensiveBook)
                .hasForeignBook(hasForeignBook)
                .build();
    }
}
