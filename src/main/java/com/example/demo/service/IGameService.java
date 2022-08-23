package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Game;

public interface IGameService {
	
	/**
	 * Returns all Games
	 * 
	 * @return the list
	 */
	public List<Game> listAllGames();
	
	/**
	 * Saves the Game
	 * 
	 * @param g
	 * @return the Game
	 */
	public Game saveGame(Game g);
	
	/**
	 * Returns a Game
	 * 
	 * @param id
	 * @return the Game
	 */
	public Game gameById(Long id);
	
	/**
	 * Returns a list of games with the same name as the one given
	 * 
	 * @param name the name
	 * @return the list of games
	 */
	public List<Game> getGamesByName(String name);
	
	/**
	 * Updates the Game
	 * 
	 * @param g
	 * @return the Game
	 */
	public Game updateGame(Game g);
	
	/**
	 * Deletes a Game
	 * 
	 * @param id
	 */
	public void deleteGame(Long id);
}
