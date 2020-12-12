package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.base.BaseDto;
import com.example.demo.dao.domain.schema.FlightData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FlightDto extends BaseDto {

    private LocalDateTime dateArrival;
    private LocalDateTime dateDepartment;
    private FlightData flightData;
    private TourDto tour;

}
