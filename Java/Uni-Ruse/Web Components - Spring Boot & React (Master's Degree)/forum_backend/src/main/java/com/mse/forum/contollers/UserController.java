package com.mse.forum.contollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mse.forum.dto.UserDTO;
import com.mse.forum.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void create(@RequestBody UserDTO user) {
		userService.saveUser(user);
	}

	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public UserDTO getUser(@RequestBody UserDTO user) {
		return userService.getUser(user);
	}
	
	@RequestMapping(path = "/me", method = RequestMethod.GET)
	public String getMe() {
		/*
		UserDetails userDetails = 
			(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		*/
		return "OK";
	}
	
	@GetMapping
	public Integer getNumberOfUsers() {
		return userService.getNumberOfUsers();
	}
	
	@GetMapping("/mods")
	public List<UserDTO> getListOfModerators() {
		return userService.getListOfModerators();
	}
	
	@GetMapping("/admins")
	public List<UserDTO> getListOfAdmins() {
		return userService.getListOfAdmins();
	}
	
}