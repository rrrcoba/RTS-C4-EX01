package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IGameDAO;
import com.example.demo.dto.Game;

@Service
public class GameServiceImpl implements IGameService{

	@Autowired
	IGameDAO iGameDAO;

	@Override
	public List<Game> listAllGames() {
		return iGameDAO.findAll();
	}

	@Override
	public Game saveGame(Game g) {
		return iGameDAO.save(g);
	}

	@Override
	public Game gameById(Long id) {
		return iGameDAO.findById(id).get();
	}

	@Override
	public List<Game> getGamesByName(String name) {
		return iGameDAO.getGamesByName(name);
	}

	@Override
	public Game updateGame(Game g) {
		return iGameDAO.save(g);
	}

	@Override
	public void deleteGame(Long id) {
		iGameDAO.deleteById(id);
	}

	
}
