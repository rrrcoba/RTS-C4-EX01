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

import com.example.demo.dto.Game;
import com.example.demo.service.GameServiceImpl;

@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	@GetMapping("/games")
	public List<Game> getAllGames() {
		return gameServiceImpl.listAllGames();
	}
	
	@PostMapping("/games")
	public Game saveGame(@RequestBody Game g) {
		return gameServiceImpl.saveGame(g);
	}
	
	@GetMapping("/games/{id}")
	public Game getGameById(@PathVariable(name = "id") Long id) {
		return gameServiceImpl.gameById(id);
	}
	
	@GetMapping("/games/name/{name}")
	public List<Game> getGamesByname(@PathVariable(name = "name") String name) {
		return gameServiceImpl.getGamesByName(name);
	}
	
	@PutMapping("/games/{id}")
	public Game updateGame(@PathVariable(name = "id") Long id, @RequestBody Game g) {
		Game selectedGame;
		Game updatedGame;

		selectedGame = gameServiceImpl.gameById(id);

		selectedGame.setName(g.getName());
		selectedGame.setType(g.getType());
		selectedGame.setAge(g.getAge());
		selectedGame.setParties(g.getParties());
		
		updatedGame = gameServiceImpl.saveGame(selectedGame);

		return updatedGame;
	}
	
	@DeleteMapping("/games/{id}")
	public void deleteGame(@PathVariable(name = "id") Long id) {
		gameServiceImpl.deleteGame(id);
	}
}
