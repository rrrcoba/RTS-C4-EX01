package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.User;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userServiceImpl.listAllUsers();
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User u) {
		return userServiceImpl.saveUser(u);
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(name="id")Long id) {
		return userServiceImpl.userById(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(name="id")Long id, @RequestBody User u) {
		User selectedUser;
		User updatedUser;
		
		selectedUser = userServiceImpl.userById(id);
		
		selectedUser.setNick(u.getNick());
		selectedUser.setNameSurname(u.getNameSurname());
		selectedUser.setSteamUser(u.getSteamUser());
		selectedUser.setParty(u.getParty());
		selectedUser.setMessages(u.getMessages());
		
		updatedUser = userServiceImpl.saveUser(selectedUser);
		
		return updatedUser;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name="id")Long id) {
		userServiceImpl.deleteUser(id);
	}
}
