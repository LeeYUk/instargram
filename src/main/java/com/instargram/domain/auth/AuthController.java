package com.instargram.domain.auth;

import com.instargram.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
@Slf4j
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/login")
    public String loginPage(){

        return "auth/login";
    }

    @GetMapping("/auth/signup")
    public String signupPage(){

        return "auth/signup";//회원가입페이지로 이동하는 요청
    }

    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto){ //key=value(x-www-form-urlencoded) 폼태그로 받은 데이터를 받음
        log.info(signupDto.toString());
        User user = signupDto.toEntity();
        log.info(user.toString());
        User userEntity=authService.signupReg(user);
        log.info(userEntity.toString());
        return "auth/login"; //회원가입이 완료되면 로그인 페이지로 이동한다.
    }
}
