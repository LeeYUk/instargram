package com.instargram.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder //Builder 패턴으로 데이터를 담을 수 있게 해주는 어노테이션
@AllArgsConstructor //모든 생성자를 자동으로 만들어주는 어노테이션
@NoArgsConstructor //빈 생성자를 자동으로 만들어주는 어노테이션
@Data //자동으로 Getter, Setter,toString을 만들어주는 에노테이션
@Entity //DB에 테이블을 생성해주는 어노테이션
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id //Primary key를 지정해주는 어노테이션
    private Integer id; //데이터가 들어갈때 번호를 매김

    private String username; //아이디

    private String password; //비밀번호

    private String name; //별명

    private String website; //개인 웹사이트 주소

    private String bio; //자기소개

    private String email; //이메일

    private String phone; //전화번호

    private String gender; // 성별

    private String prifileImageUrl; // 프로필 사진

    private String role; // 권한

    private LocalDateTime createDate; //데이터가 입력된 시간


    @PrePersist //DB에 데이터가 INSERT되기 직전에 실행
    public void createDate(){
        this.createDate=LocalDateTime.now();
    }
}
