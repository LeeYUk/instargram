package com.instargram.domain.auth;

import com.instargram.model.User;
import com.instargram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    //회원가입 진행
    public User signupReg(User user) {
        User userEntity = userRepository.save(user);

        return userEntity;
    }
}
