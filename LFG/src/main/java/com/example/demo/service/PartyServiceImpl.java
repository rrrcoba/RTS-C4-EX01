package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPartyDAO;
import com.example.demo.dto.Party;

@Service
public class PartyServiceImpl implements IPartyService{

	@Autowired
	IPartyDAO iPartyDAO;

	@Override
	public List<Party> listParties() {
		return iPartyDAO.findAll();
	}

	@Override
	public Party saveParty(Party p) {
		return iPartyDAO.save(p);
	}

	@Override
	public Party partyById(Long id) {
		return iPartyDAO.findById(id).get();
	}

	@Override
	public List<Party> getPartiesByName(String name) {
		return iPartyDAO.getPartiesByName(name);
	}

	@Override
	public Party updateParty(Party p) {
		return iPartyDAO.save(p);
	}

	@Override
	public void deleteParty(Long id) {
		iPartyDAO.deleteById(id);
	}

	
}
