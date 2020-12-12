package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.schema.CountryData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDto {

    private String name;
    private CountryData countryData;

}
