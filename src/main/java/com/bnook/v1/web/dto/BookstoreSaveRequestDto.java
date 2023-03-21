package com.bnook.v1.web.dto;

import com.bnook.v1.domain.bookstore.Bookstore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookstoreSaveRequestDto {
    private Long storeId;
    private String storeName;
    private String ownerName;
    private String address;
    private String phoneNo;

    @Builder
    public BookstoreSaveRequestDto(String storeName, String ownerName, String address, String phoneNo) {
        this.storeName = storeName;
        this.ownerName = ownerName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Bookstore toEntity() {
        return Bookstore.builder()
                .storeName(storeName)
                .ownerName(ownerName)
                .address(address)
                .phoneNo(phoneNo)
                .build();
    }
}
