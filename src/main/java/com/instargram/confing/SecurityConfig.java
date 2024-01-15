package com.instargram.confing;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity//해당 파일로 시큐리티를 활성화
@Configuration//IOC
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //인증이 되지않은 모든 사용자는 로그인페이지로 이동
        http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        http.csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/auth/**", "/css/**", "/images/**", "/js/**").permitAll()//해당 요청은 허용
                        .anyRequest().authenticated())//설정된 값들 이외 나머지 URL은 인증된 접근 가능
                .formLogin(formLogin->formLogin
                        .loginPage("/auth/login")//GET
                        .defaultSuccessUrl("/"));

        return http.build();
    }
}
