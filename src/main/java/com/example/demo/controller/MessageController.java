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

import com.example.demo.dto.Message;
import com.example.demo.service.MessageServiceImpl;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	MessageServiceImpl messageServiceImpl;

	@GetMapping("/messages")
	public List<Message> getAllMessages() {
		return messageServiceImpl.listAllMessages();
	}

	@PostMapping("/messages")
	public Message saveMessage(@RequestBody Message m) {
		return messageServiceImpl.saveMessage(m);
	}

	@GetMapping("/messages/{id}")
	public Message messageSaleById(@PathVariable(name = "id") Long id) {
		return messageServiceImpl.messageById(id);
	}

	@PutMapping("/messages/{id}")
	public Message updateMessage(@PathVariable(name = "id") Long id, @RequestBody Message m) {
		Message selectedMessage;
		Message updatedMessage;

		selectedMessage = messageServiceImpl.messageById(id);

		selectedMessage.setContent(m.getContent());
		selectedMessage.setUser(m.getUser());

		updatedMessage = messageServiceImpl.saveMessage(selectedMessage);

		return updatedMessage;
	}

	@DeleteMapping("/messages/{id}")
	public void deleteMessage(@PathVariable(name = "id") Long id) {
		messageServiceImpl.deleteMessage(id);
	}
}
