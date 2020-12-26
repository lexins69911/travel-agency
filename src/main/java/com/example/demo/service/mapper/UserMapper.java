package com.example.demo.service.mapper;

import com.example.demo.dao.domain.dto.UserDto;
import com.example.demo.dao.domain.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto (UserEntity entity);
    UserEntity toEntity(UserDto dto);

    List<UserEntity> toListEntity(List<UserDto> list);
    List<UserDto> toListDto(List<UserEntity> list);

    Set<UserEntity> toSetEntity(Set<UserDto> set);
    Set<UserDto> toSetDto(Set<UserEntity> set);
}
