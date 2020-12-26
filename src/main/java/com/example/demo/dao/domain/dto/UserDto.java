package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.base.BaseDto;
import com.example.demo.dao.domain.schema.enums.Role;
import com.example.demo.dao.domain.schema.jsonb.UserData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends BaseDto {

    private String login;
    private String password;
    private Role role;
    private UserData userData;
    private Set<BillDto> bills;

}
