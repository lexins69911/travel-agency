package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.TourDto;
import com.example.demo.dao.domain.model.TourEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TourMapper {

    TourEntity toEntity(TourDto dto);
    TourDto toDto(TourEntity entity);

}
