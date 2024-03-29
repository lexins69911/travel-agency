package com.example.demo.dao.domain.schema.jsonb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CountryData implements Serializable {

    private String EN;
    private String RUS;

}
