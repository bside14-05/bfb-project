package com.bnook.v1.web.dto;

import com.bnook.v1.domain.bookstore.Bookstore;
import lombok.Getter;

@Getter
public class BookstoreResponseDto {
    private Long storeId;
    private String storeName;
    private String ownerName;
    private String address;
    private String phoneNo;

    public BookstoreResponseDto(Bookstore entity) {
        this.storeId = entity.getStoreId();
        this.storeName = entity.getStoreName();
        this.ownerName = entity.getOwnerName();
        this.address = entity.getAddress();
        this.phoneNo = entity.getPhoneNo();
    }
}
