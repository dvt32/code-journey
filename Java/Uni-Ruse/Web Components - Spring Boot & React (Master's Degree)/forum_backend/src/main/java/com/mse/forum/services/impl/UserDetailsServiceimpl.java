package com.mse.forum.services.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mse.forum.persistance.UserRepository;
import com.mse.forum.persistance.entities.UserEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserDetailsServiceimpl 
	implements UserDetailsService 
{
	private UserRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = 
			usersRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException());

		return 
			User.builder()
				.username(user.getUsername())
				.password(passwordEncoder().encode(user.getPassword()))
				.roles("ADMIN")
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}