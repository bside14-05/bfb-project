package com.bnook.v1.domain.bookstore;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookstoreRepositoryTest {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    private String storeName = "작은책방";
    private String ownerName = "김미희";
    private String address = "서울시 강남구 방배동";
    private String phoneNo = "010-9999-2222";

    @After
    public void cleanup() {
        bookstoreRepository.deleteAll();
    }

    @Test
    public void BaseEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        bookstoreRepository.save(Bookstore.builder().storeName(storeName).build());

        // when
        List<Bookstore> bookstoreList = bookstoreRepository.findAll();

        // then
        Bookstore bookstore = bookstoreList.get(0);
        assertThat(bookstore.getCreatedDate()).isAfter(now);
        assertThat(bookstore.getModifiedDate()).isAfter(now);

    }

    @Test
    public void 서점_저장_후_목록_불러오기() {
        // given
        bookstoreRepository.save(Bookstore.builder()
                .storeName(storeName)
                .ownerName(ownerName)
                .address(address)
                .phoneNo(phoneNo)
                .build());

        // when
        List<Bookstore> bookstoreList = bookstoreRepository.findAll();

        // then
        Bookstore bookstore = bookstoreList.get(0);
        assertThat(bookstore.getStoreName()).isEqualTo(storeName);
        assertThat(bookstore.getOwnerName()).isEqualTo(ownerName);
    }

}
