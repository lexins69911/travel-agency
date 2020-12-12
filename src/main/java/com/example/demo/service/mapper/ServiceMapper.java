package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.ServiceDto;
import com.example.demo.dao.domain.model.ServiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    ServiceEntity toEntity(ServiceDto dto);
    ServiceDto toDto(ServiceEntity entity);

}
