package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.FlightDto;
import com.example.demo.dao.domain.model.FlightEntity;
import org.mapstruct.Mapper;

@Mapper
public interface FlightMapper {

    FlightEntity toEntity(FlightDto dto);

    FlightDto toDto(FlightEntity entity);
}
