package com.bnook.v1.service.user;

import com.bnook.v1.domain.user.User;
import com.bnook.v1.domain.user.UserRepository;
import com.bnook.v1.web.user.dto.UserResponseDto;
import com.bnook.v1.web.user.dto.UserSaveRequestDto;
import com.bnook.v1.web.user.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원을 저장한다.
     * @param requestDto
     * @return
     */
    @Transactional
    public String save(UserSaveRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getNickName();
    }


    /**
     * 회원을 탈퇴한다.
     * @param email
     */
    @Transactional
    public void delete(String email) {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new IllegalArgumentException(email + "에 해당하는 회원은 없습니다"));
//        userRepository.delete(user);
    }


    /**
     *
     * @param storeId
     */
    public void likeBookstore(String storeId) {

    }
}
