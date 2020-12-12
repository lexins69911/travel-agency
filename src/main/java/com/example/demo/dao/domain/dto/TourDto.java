package com.example.demo.dao.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TourDto {

    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int count;
    private byte[] tourData;
    private HotelDto hotel;

}
