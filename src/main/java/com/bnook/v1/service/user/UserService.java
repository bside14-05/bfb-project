package com.bnook.v1.service.user;

import com.bnook.v1.domain.bookstore.Bookstore;
import com.bnook.v1.domain.user.User;
import com.bnook.v1.domain.user.UserRepository;
import com.bnook.v1.web.TasteResult;
import com.bnook.v1.web.dto.BookstoreListResponseDto;
import com.bnook.v1.web.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * 내 정보 조회
     */
    public UserResponseDto getMyInfo(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 회원이 없습니다."));

        return UserResponseDto.builder()
                .email(user.getEmail())
                .nickName(user.getNickName())
                .build();
    }

    /**
     * 서점 찜 등록
     * @param bookstore, userId
     */
    public void addMyBookstore(Bookstore bookstore, String userId) {
    }

    /**
     * 찜한 서점 목록 조회
     * @param email
     */
    public List<BookstoreListResponseDto> getMyBookstoreList(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 회원이 없습니다."));

        List<BookstoreListResponseDto> returnList = Collections.emptyList();

        for (Bookstore myStore : user.getMyBookstores()) {
            BookstoreListResponseDto dto = new BookstoreListResponseDto(myStore);
            returnList.add(dto);
        }

        return returnList;
    }


    /**
     * 취향 테스트 결과 등록
     * @param tasteResult, userId
     */
    public void addMyTasteResult(TasteResult tasteResult, String userId) {

    }



}
