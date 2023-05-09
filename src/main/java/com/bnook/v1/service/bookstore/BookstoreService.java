package com.bnook.v1.service.bookstore;

import com.bnook.v1.domain.bookstore.Bookstore;
import com.bnook.v1.domain.bookstore.BookstoreRepository;
import com.bnook.v1.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookstoreService {

    private final BookstoreRepository bookstoreRepository;

    @Transactional(readOnly = true)
    public BookstoreResponseDto findById(Long bookstoreId) throws Exception {
        Bookstore entity = bookstoreRepository.findById(bookstoreId)
                .orElseThrow(() -> new IllegalArgumentException(bookstoreId + "에 해당하는 서점은 없습니다"));
        return new BookstoreResponseDto(entity);
    }

    @Transactional
    public BookstoreResponseDto findBookstoreBusinessHours(Long bookstoreId) throws Exception{
        Bookstore entity = bookstoreRepository.findBookstoreBusinessHours(bookstoreId);
        return new BookstoreResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BookstoreListResponseDto> findAllDesc() {
        return bookstoreRepository.findAllDesc().stream()
                .map(BookstoreListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(BookstoreRequestDto requestDto) {
        return bookstoreRepository.save(requestDto.toEntity()).getBookstoreId();
    }

    @Transactional
    public Long update(Long storeId, BookstoreRequestDto requestDto) {
        Bookstore bookstore = bookstoreRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException(storeId + "에 해당하는 서점은 없습니다"));
//        bookstore.update(requestDto.getStoreName(), requestDto.getOwnerName(), requestDto.getAddress(), requestDto.getPhoneNo());
        return storeId;
    }

    @Transactional
    public void delete(Long storeId) {
        Bookstore bookstore = bookstoreRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException(storeId + "에 해당하는 서점은 없습니다"));
        bookstoreRepository.delete(bookstore);
    }

}
