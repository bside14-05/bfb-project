package com.bnook.v1.web.dto;

import com.bnook.v1.domain.bookstore.Bookstore;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class BookstoreListResponseDto {
    private Long storeId;
    private String storeName;
    private String ownerName;
    private String address;
    private String phoneNo;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BookstoreListResponseDto(Bookstore entity) {
        this.storeId = entity.getStoreId();
        this.storeName = entity.getStoreName();
        this.ownerName = entity.getOwnerName();
        this.address = entity.getAddress();
        this.phoneNo = entity.getPhoneNo();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
