package com.bnook.v1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookstoreUpdateRequestDto {

    private Long storeId;
    private String storeName;
    private String ownerName;
    private String address;
    private String phoneNo;

    @Builder
    public BookstoreUpdateRequestDto(String storeName, String ownerName, String address, String phoneNo) {
        this.storeName = storeName;
        this.ownerName = ownerName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

}
