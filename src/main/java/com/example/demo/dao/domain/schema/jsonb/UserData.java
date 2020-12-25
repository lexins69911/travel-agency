package com.example.demo.dao.domain.schema.jsonb;

import com.example.demo.dao.domain.schema.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserData implements Serializable {

    private String firstName;
    private String secondName;
    private Integer age;
    private Gender gender;

}
