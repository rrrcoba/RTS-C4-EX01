package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.User;

public interface IUserService {
	
	/**
	 * Lists all the User
	 * @return
	 */
	public List<User> listAllUsers();
	
	/**
	 * Saves a User
	 * @param u
	 * @return
	 */
	public User saveUser(User u);
	
	/**
	 * Gets the User by ID
	 * @param id
	 * @return
	 */
	public User userById(Long id);
	
	/**
	 * Updates the User
	 * @param u
	 * @return
	 */
	public User updateUser(User u);
	
	/**
	 * Deletes the User
	 * @param id
	 */
	public void deleteUser(Long id);

}
