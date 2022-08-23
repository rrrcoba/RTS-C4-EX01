package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMessageDAO;
import com.example.demo.dto.Message;

@Service
public class MessageServiceImpl implements IMessageService{
	
	@Autowired
	IMessageDAO iMessageDAO;

	@Override
	public List<Message> listAllMessages() {
		return iMessageDAO.findAll();
	}

	@Override
	public Message saveMessage(Message m) {
		return iMessageDAO.save(m);
	}

	@Override
	public Message messageById(Long id) {
		return iMessageDAO.findById(id).get();
	}

	@Override
	public Message updateMessage(Message m) {
		return iMessageDAO.save(m);
	}

	@Override
	public void deleteMessage(Long id) {
		iMessageDAO.deleteById(id);
	}	
}
