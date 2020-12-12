package com.example.demo.dao.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelDto {

    private String name;
    private byte[] hotelData;
    private CountryDto countryDto;

}
