package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.base.BaseDto;
import com.example.demo.dao.domain.schema.jsonb.HotelData;
import com.example.demo.dao.domain.schema.jsonb.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HotelDto extends BaseDto {

    private String name;
    private List<Room> roomList;
    private HotelData hotelData;
    private CountryDto country;

}
