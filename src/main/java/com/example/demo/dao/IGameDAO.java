package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Game;

public interface IGameDAO extends JpaRepository<Game, Long>{
	
	/**
	 * Gets a list of games with the same name as the one given
	 * 
	 * @param name the name of the game
	 * @return list of games with the same name
	 */
	public List<Game> getGamesByName(String name);
}
