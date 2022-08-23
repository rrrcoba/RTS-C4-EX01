package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Message;

public interface IMessageService {
	
	/**
	 * Lists all the Message
	 * @return
	 */
	public List<Message> listAllMessages();
	
	/**
	 * Saves a Message
	 * @param m
	 * @return
	 */
	public Message saveMessage(Message m);
	
	/**
	 * Gets the Message by ID
	 * @param id
	 * @return
	 */
	public Message messageById(Long id);
	
	/**
	 * Updates the Message
	 * @param r
	 * @return
	 */
	public Message updateMessage(Message m);
	
	/**
	 * Deletes the Message
	 * @param id
	 */
	public void deleteMessage(Long id);
}