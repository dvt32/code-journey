package com.mse.forum.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.mse.forum.dto.UserDTO;
import com.mse.forum.persistance.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDTO toDto(UserEntity entity);
	UserEntity toEntity(UserDTO dto);
	List<UserDTO> toDtoList(List<UserEntity> entityList);
	List<UserEntity> toEntityList(List<UserDTO> dtoList);
}
