package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Party;
import com.example.demo.service.PartyServiceImpl;

@RestController
@RequestMapping("/api")
public class PartyController {

	@Autowired
	PartyServiceImpl partyServiceImpl;
	
	@GetMapping("/parties")
	public List<Party> getAllParties() {
		return partyServiceImpl.listParties();
	}
	
	@PostMapping("/parties")
	public Party saveParty(@RequestBody Party p) {
		return partyServiceImpl.saveParty(p);
	}
	
	@GetMapping("/parties/{id}")
	public Party getPartyById(@PathVariable(name="id") Long id) {
		return partyServiceImpl.partyById(id);
	}
	
	@GetMapping("/parties/name/{name}")
	public List<Party> listPartiesByName(@PathVariable(name = "name") String name) {
		return partyServiceImpl.getPartiesByName(name);
	}
	
	@PutMapping("/parties/{id}")
	public Party updateParty(@PathVariable(name="id") Long id, @RequestBody Party p) {
		Party selectedParty;
		Party updatedParty;
		
		selectedParty = partyServiceImpl.partyById(id);
		
		selectedParty.setName(p.getName());
		selectedParty.setGame(p.getGame());
		selectedParty.setUsers(p.getUsers());
		
		updatedParty = partyServiceImpl.saveParty(selectedParty);
		
		return updatedParty;
	}
	
	@DeleteMapping("/parties/{id}")
	public void deleteParty(@PathVariable(name="id") Long id) {
		partyServiceImpl.deleteParty(id);
	}
}
