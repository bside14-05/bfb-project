package com.bnook.v1.web;

import com.bnook.v1.domain.bookstore.Bookstore;
import com.bnook.v1.domain.bookstore.BookstoreRepository;
import com.bnook.v1.web.dto.BookstoreSaveRequestDto;
import com.bnook.v1.web.dto.BookstoreUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookstoreApiControllerTest {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String url = "http://localhost:8043/api/v1/bookstore";

    private String storeName = "작은책방";
    private String address = "서울시 강남구 방배동";
    private String phoneNo = "010-9999-2222";

    @After
    public void cleanup() {
        bookstoreRepository.deleteAll();
    }

    @Test
    public void 서점_수정된다() throws Exception {
        // given
        Bookstore saved = bookstoreRepository.save(Bookstore.builder()
                .bookstoreName(storeName)
                .address(address)
                .phoneNo(phoneNo)
                .build());

        String expectedStoreName = "큰책방";

        BookstoreUpdateRequestDto requestDto = BookstoreUpdateRequestDto.builder()
                .bookstoreName(expectedStoreName)
                .build();

        String url = "http://localhost:8043/api/v1/bookstore/" + saved.getBookstoreId();

        HttpEntity<BookstoreUpdateRequestDto> httpEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT, httpEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Bookstore> bookstoreList = bookstoreRepository.findAll();
        assertThat(bookstoreList.get(0).getBookstoreName()).isEqualTo(expectedStoreName);

    }

    @Test
    public void 서점_등록된다() throws Exception {
        // given
        BookstoreSaveRequestDto requestDto = BookstoreSaveRequestDto.builder()
                .bookstoreName(storeName)
                .address(address)
                .phoneNo(phoneNo)
                .build();


        // when
        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Bookstore> all = bookstoreRepository.findAll();
        assertThat(all.get(0).getBookstoreName()).isEqualTo(storeName);
        assertThat(all.get(0).getAddress()).isEqualTo(address);
        assertThat(all.get(0).getPhoneNo()).isEqualTo(phoneNo);

    }


}
