package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.TourDto;
import com.example.demo.dao.domain.model.TourEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface TourMapper {

    TourEntity toEntity(TourDto dto);
    TourDto toDto(TourEntity entity);

    List<TourDto> toListDto(List<TourEntity> list);
    List<TourEntity> toListEntity(List<TourDto> list);

    Set<TourDto> toSetDto(Set<TourEntity> set);
    Set<TourEntity> toSetEntity(Set<TourDto> set);
}
