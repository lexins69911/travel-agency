package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.schema.HotelData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelDto {

    private String name;
    private HotelData hotelData;
    private CountryDto countryDto;

}
