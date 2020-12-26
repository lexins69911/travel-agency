package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.BillDto;
import com.example.demo.dao.domain.model.BillEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface BillMapper {

    BillEntity toEntity(BillDto dto);
    BillDto toDto(BillEntity entity);

    List<BillEntity> toListEntity(List<BillDto> list);
    List<BillDto> toListDto(List<BillEntity> list);

    Set<BillEntity> toSetEntity(Set<BillDto> set);
    Set<BillDto> toSetDto(Set<BillEntity> set);

}
