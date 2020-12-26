package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.base.BaseDto;
import com.example.demo.dao.domain.schema.jsonb.Services;
import com.example.demo.dao.domain.schema.jsonb.TourData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TourDto extends BaseDto {

    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private TourData tourData;
    private HotelDto hotel;
    private List<Services> services;

}
