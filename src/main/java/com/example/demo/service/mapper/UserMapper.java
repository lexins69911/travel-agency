package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.UserDto;
import com.example.demo.dao.domain.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto (UserEntity entity);
    UserEntity toEntity(UserDto dto);

}
