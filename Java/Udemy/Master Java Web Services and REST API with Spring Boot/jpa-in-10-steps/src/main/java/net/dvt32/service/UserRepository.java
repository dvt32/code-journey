package net.dvt32.service;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dvt32.entity.User;

public interface UserRepository 
	extends JpaRepository<User, Long>
{

}
