package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Party;

public interface IPartyDAO extends JpaRepository<Party, Long>{
	
	/**
	 * Gets the parties of the same name as the one given
	 * 
	 * @param name the name of the party
	 * @return list of the parties with the same name
	 */
	public List<Party> getPartiesByName(String name);
}
