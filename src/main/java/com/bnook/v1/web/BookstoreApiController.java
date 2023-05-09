package com.bnook.v1.web;

import com.bnook.v1.service.bookstore.BookstoreService;
import com.bnook.v1.web.dto.BookstoreListResponseDto;
import com.bnook.v1.web.dto.BookstoreRequestDto;
import com.bnook.v1.web.dto.BookstoreResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/bookstore")
@RestController
public class BookstoreApiController {

    private final BookstoreService bookstoreService;

    @GetMapping("/{bookstoreId}")
    public BookstoreResponseDto bookstoreDetails(@PathVariable Long bookstoreId) throws Exception {
//        return bookstoreService.findById(bookstoreId);
        return bookstoreService.findBookstoreBusinessHours(bookstoreId);
    }

//    @GetMapping
//    public List<BookstoreListResponseDto> findAllDesc() {
//        return bookstoreService.findAllDesc();
//    }
//
//    @PostMapping
//    public Long save(@RequestBody BookstoreRequestDto requestDto) {
//        return bookstoreService.save(requestDto);
//    }
//
//    @PutMapping("/{storeId}")
//    public Long update(@PathVariable Long storeId, @RequestBody BookstoreRequestDto requestDto) {
//        return bookstoreService.update(storeId, requestDto);
//    }
//
//    @DeleteMapping("/{storeId}")
//    public Long delete(@PathVariable Long storeId) {
//        bookstoreService.delete(storeId);
//        return storeId;
//    }

}
