package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.CountryDto;
import com.example.demo.dao.domain.model.CountryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryEntity toDto(CountryDto dto);
    CountryDto toDto(CountryEntity entity);

}
