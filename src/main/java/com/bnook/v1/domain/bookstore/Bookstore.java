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
    private Long storeId;

    @Column(nullable = false)
    private String storeName;

    private String ownerName;

    private String address;

    private String phoneNo;

    @Builder
    public Bookstore(String storeName, String ownerName, String address, String phoneNo) {
        this.storeName = storeName;
        this.ownerName = ownerName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public void update(String storeName, String ownerName, String address, String phoneNo) {
        this.storeName = storeName;
        this.ownerName = ownerName;
        this.address = address;
        this.phoneNo = phoneNo;
    }
}
