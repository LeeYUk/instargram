package com.instargram.domain.auth;

import lombok.Data;

@Data //Getter, Setter
public class SignDto {

    private String username;
    private String password;
    private String email;
    private String name;
}
