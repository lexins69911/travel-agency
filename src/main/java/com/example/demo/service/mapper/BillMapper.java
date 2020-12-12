package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.BillDto;
import com.example.demo.dao.domain.model.BillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    BillEntity toEntity(BillDto dto);
    BillDto toDto(BillEntity entity);

}
