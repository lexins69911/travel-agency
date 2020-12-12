package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.schema.UserData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String login;
    private String password;
    private String role;
    private UserData userData;

}
