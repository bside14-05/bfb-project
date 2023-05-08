package com.bnook.v1.domain.bookstore;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreDataJpaTest {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    private String bookstoreName = "작은책방";
    private String address = "서울시 강남구 방배동";
    private String phoneNo = "010-9999-2222";

    @Test
    public void 서점저장_후_아이디로_서점검색() throws Exception {
        // given
        bookstoreRepository.save(Bookstore.builder()
                .bookstoreName(bookstoreName)
                .address(address)
                .phoneNo(phoneNo)
                .build());

        // when
        Bookstore bookstore = bookstoreRepository.findById(1L).orElseThrow(IllegalArgumentException::new);

        // then
        assertThat(bookstore).isNotNull();
        assertThat(bookstore.getBookstoreName()).isEqualTo(bookstoreName);
        assertThat(bookstore.getAddress()).isEqualTo(address);
        assertThat(bookstore.getPhoneNo()).isEqualTo(phoneNo);

        System.out.println(bookstore.getBookstoreName());
        System.out.println(bookstore.getAddress());
        System.out.println(bookstore.getPhoneNo());
    }

    @Test
    public void 서점_저장_후_목록_불러오기() {

        bookstoreName = "비사이드책방";
        address = "서울시 동작구";
        phoneNo = "02-1234-5678";

        // given
        bookstoreRepository.save(Bookstore.builder()
                .bookstoreName(bookstoreName)
                .address(address)
                .phoneNo(phoneNo)
                .build());

        // when
        List<Bookstore> bookstoreList = bookstoreRepository.findAll();

        // then
        Bookstore bookstore = bookstoreList.get(0);
        assertThat(bookstore.getBookstoreName()).isEqualTo(bookstoreName);
    }

}
