package com.bnook.v1.web.dto;

import com.bnook.v1.domain.bookstore.Bookstore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BookstoreSaveRequestDto {
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

    @Builder
    public BookstoreSaveRequestDto(String bookstoreName, String ownerComment, String address, String phoneNo, String instagramId, String facebookId, String blogId, String website, String programCategory1, String programCategory2, String programCategory3, boolean isBeverageAlcohol, boolean isArtExhibition, boolean isMerchandiseSale, boolean isProgramOperating, boolean isOther, boolean hasIndieBook, boolean hasSpecializedBook, boolean hasComprehensiveBook, boolean hasForeignBook) {
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
