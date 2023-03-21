package com.bnook.v1.web;

import com.bnook.v1.service.bookstore.BookstoreService;
import com.bnook.v1.web.dto.BookstoreListResponseDto;
import com.bnook.v1.web.dto.BookstoreResponseDto;
import com.bnook.v1.web.dto.BookstoreSaveRequestDto;
import com.bnook.v1.web.dto.BookstoreUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/bookstore")
@RestController
public class BookstoreApiController {

    private final BookstoreService bookstoreService;

    @GetMapping
    public List<BookstoreListResponseDto> findAllDesc() {
        return bookstoreService.findAllDesc();
    }

    @GetMapping("/{storeId}")
    public BookstoreResponseDto findById(@PathVariable Long storeId) {
        return bookstoreService.findById(storeId);
    }

    @PostMapping
    public Long save(@RequestBody BookstoreSaveRequestDto requestDto) {
        return bookstoreService.save(requestDto);
    }

    @PutMapping("/{storeId}")
    public Long update(@PathVariable Long storeId, @RequestBody BookstoreUpdateRequestDto requestDto) {
        return bookstoreService.update(storeId, requestDto);
    }

    @DeleteMapping("/{storeId}")
    public Long delete(@PathVariable Long storeId) {
        bookstoreService.delete(storeId);
        return storeId;
    }

}
