package com.mse.forum.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.forum.persistance.entities.Roles;
import com.mse.forum.persistance.entities.UserEntity;

public interface UserRepository 
	extends JpaRepository<UserEntity, Long> 
{
	Optional<UserEntity> findByUsername(String username);
	List<UserEntity> findByRole(Roles role);
}