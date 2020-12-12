package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.HotelDto;
import com.example.demo.dao.domain.model.HotelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelEntity toEntity(HotelDto dto);
    HotelDto toDto(HotelEntity entity);

}
