package com.bnook.v1.service.bookstore;

import com.bnook.v1.domain.bookstore.Bookstore;
import com.bnook.v1.domain.bookstore.BookstoreRepository;
import com.bnook.v1.web.dto.BookstoreListResponseDto;
import com.bnook.v1.web.dto.BookstoreResponseDto;
import com.bnook.v1.web.dto.BookstoreSaveRequestDto;
import com.bnook.v1.web.dto.BookstoreUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookstoreService {

    private final BookstoreRepository bookstoreRepository;

    @Transactional(readOnly = true)
    public List<BookstoreListResponseDto> findAllDesc() {
        return bookstoreRepository.findAllDesc().stream()
                .map(BookstoreListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookstoreResponseDto findById(Long storeId) {
        Bookstore entity = bookstoreRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException(storeId + "에 해당하는 서점은 없습니다"));
        return new BookstoreResponseDto(entity);
    }

    @Transactional
    public Long save(BookstoreSaveRequestDto requestDto) {
        return bookstoreRepository.save(requestDto.toEntity()).getStoreId();
    }

    @Transactional
    public Long update(Long storeId, BookstoreUpdateRequestDto requestDto) {
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
