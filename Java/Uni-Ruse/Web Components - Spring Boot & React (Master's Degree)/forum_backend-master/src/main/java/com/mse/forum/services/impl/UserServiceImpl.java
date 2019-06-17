package com.mse.forum.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.UserDTO;
import com.mse.forum.mappers.UserMapper;
import com.mse.forum.persistance.UserRepository;
import com.mse.forum.persistance.entities.Roles;
import com.mse.forum.persistance.entities.UserEntity;
import com.mse.forum.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl 
	implements UserService 
{
	private UserRepository userRepository;

	private UserMapper mapper;

	@Override
	public boolean saveUser(UserDTO user) {
		UserEntity entity = mapper.toEntity(user);
		entity.setRole(Roles.USER);
		userRepository.save(entity);
		return true;
	}

	@Override
	public UserDTO getUser(UserDTO user) {
		Optional<UserEntity> findByUsername = userRepository.findByUsername(user.getUsername());
		UserEntity userEntity = findByUsername.get();
		UserDTO dto = mapper.toDto(userEntity);
		return dto;
	}

	@Override
	public Integer getNumberOfUsers() {
		Integer numberOfUsers = userRepository.findAll().size();
		return numberOfUsers;
	}

	@Override
	public List<UserDTO> getListOfModerators() {
		List<UserEntity> listOfModeratorEntities = userRepository.findByRole(Roles.MODERATOR);
		List<UserDTO> listOfModeratorDtos = mapper.toDtoList(listOfModeratorEntities);
		return listOfModeratorDtos;
	}

	@Override
	public List<UserDTO> getListOfAdmins() {
		List<UserEntity> listOfAdminEntities = userRepository.findByRole(Roles.ADMIN);
		List<UserDTO> listOfAdminDtos = mapper.toDtoList(listOfAdminEntities);
		return listOfAdminDtos;
	}

}