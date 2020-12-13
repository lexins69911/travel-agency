package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.base.BaseDto;
import com.example.demo.dao.domain.schema.jsonb.CountryData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDto extends BaseDto {

    private String name;
    private CountryData countryData;

}
