package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Party;

public interface IPartyService {
	/**
	 * Lists all the parties
	 * @return
	 */
	public List<Party> listParties();
	
	/**
	 * Saves a Party
	 * @param p
	 * @return
	 */
	public Party saveParty(Party p);
	
	/**
	 * Gets the Party by ID
	 * @param id
	 * @return
	 */
	public Party partyById(Long id);
	
	/**
	 * Gets a list of parties with the same name
	 * @param name
	 * @return the list of parties
	 */
	public List<Party> getPartiesByName(String name);
	
	/**
	 * Updates the Party
	 * @param p
	 * @return
	 */
	public Party updateParty(Party p);
	
	/**
	 * Deletes the Party
	 * @param id
	 */
	public void deleteParty(Long id);
}
