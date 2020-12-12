package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.base.BaseDto;
import com.example.demo.dao.domain.schema.TourData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TourDto extends BaseDto {

    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int count;
    private TourData tourData;
    private HotelDto hotel;

}
