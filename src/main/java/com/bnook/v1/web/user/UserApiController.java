package com.bnook.v1.web.user;


import com.bnook.v1.domain.bookstore.Bookstore;
import com.bnook.v1.service.user.UserService;
import com.bnook.v1.web.TasteResult;
import com.bnook.v1.web.dto.BookstoreResponseDto;
import com.bnook.v1.web.user.dto.UserResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    /**
     * 내정보 조회
     */
    @GetMapping("/user")
    public ResponseEntity<UserResponseDto> getMyInfo(HttpServletRequest request, Principal principal) throws Exception{
        String email = principal.getName();  // 수정
        return new ResponseEntity(userService.getMyInfo(email), HttpStatus.OK);
    }

    /**
     * 서점 찜 등록
     * @param bookstore
     */
    @PostMapping("/user/like")
    public void addMyBookstore(@RequestParam Bookstore bookstore, Principal principal) {
        String userId = principal.getName();
        userService.addMyBookstore(bookstore, userId);
    }

    /**
     * 찜한 서점 목록 조회
     * @param principal
     */
    @GetMapping("/user/like")
    public ResponseEntity<List<BookstoreResponseDto>> getMyBookstoreList(Principal principal) {
        String userId = principal.getName();
        return new ResponseEntity(userService.getMyBookstoreList(userId), HttpStatus.OK);
    }

    /**
     * 취향 테스트 결과 등록
     * @param principal
     */
    @PostMapping("/user/myTaste")
    public void addMyTasteResult(@RequestParam TasteResult tasteResult, Principal principal) {
        String userId = principal.getName();
        userService.addMyTasteResult(tasteResult, userId);
    }

}
