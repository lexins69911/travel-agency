package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.schema.RoomData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomDto {

    private int roomSize;
    private String category;
    private int count;
    private RoomData roomDate;
    private HotelDto hotel;
}
