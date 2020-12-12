package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.RoomDto;
import com.example.demo.dao.domain.model.RoomEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoomMapper {

    RoomEntity toEntity(RoomDto dto);
    RoomDto toDto(RoomEntity entity);

}
