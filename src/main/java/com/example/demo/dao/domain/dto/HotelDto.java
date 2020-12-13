package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.base.BaseDto;
import com.example.demo.dao.domain.schema.jsonb.HotelData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelDto extends BaseDto {

    private String name;
    private HotelData hotelData;
    private CountryDto countryDto;

}
