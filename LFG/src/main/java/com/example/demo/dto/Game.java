package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String type;

	private int age;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Party> parties;

	
	// Constructors

	/**
	 * Default constructor
	 */
	public Game() {
	}

	/**
	 * Constructor with fields
	 * 
	 * @param id
	 * @param name
	 * @param type
	 * @param age
	 * @param parties
	 */
	public Game(Long id, String name, String type, int age, List<Party> parties) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.age = age;
		this.parties = parties;
	}

	
	// Getters and setters

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param parties the parties to set
	 */
	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	/**
	 * @return the parties
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Party")
	public List<Party> getParties() {
		return parties;
	}
}
