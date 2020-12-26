package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.CountryDto;
import com.example.demo.dao.domain.model.CountryEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryEntity toEntity(CountryDto dto);
    CountryDto toDto(CountryEntity entity);

    List<CountryDto> toListDto(List<CountryEntity> list);
    List<CountryEntity> toListEntity(List<CountryDto> list);

    Set<CountryEntity> toSetEntity(Set<CountryDto> set);
    Set<CountryDto> toSetDto(Set<CountryEntity> set);

}
