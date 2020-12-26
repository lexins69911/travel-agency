package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.HotelDto;
import com.example.demo.dao.domain.model.HotelEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelEntity toEntity(HotelDto dto);
    HotelDto toDto(HotelEntity entity);

    List<HotelEntity> toListEntity(List<HotelDto> list);
    List<HotelDto> toListDto(List<HotelEntity> list);

    Set<HotelEntity> toSetEntity(Set<HotelDto> set);
    Set<HotelDto> toSetDto(Set<HotelEntity> set);
}
