package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nick;
	
	@Column(name="name_surname")
	private String nameSurname;
	
	@Column(name="steam_user")
	private String steamUser;
	
	@ManyToOne
	@JoinColumn(name="party")
	private Party party ;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Message> messages;
	
	
	// Constructors
	
	/**
	 * Default constructor
	 */
	public User () {
		
	}
	
	/**
	 * Constructor with fields
	 * 
	 * @param id
	 * @param nick
	 * @param nameSurname
	 * @param steamUser
	 * @param party
	 * @param messages
	 */
	public User(Long id, String nick, String nameSurname, String steamUser, Party party, List<Message> messages) {
		this.id = id;
		this.nick = nick;
		this.nameSurname = nameSurname;
		this.steamUser = steamUser;
		this.party = party;
		this.messages = messages;
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
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * @return the nameSurname
	 */
	public String getNameSurname() {
		return nameSurname;
	}

	/**
	 * @param nameSurname the nameSurname to set
	 */
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	/**
	 * @return the steamUser
	 */
	public String getSteamUser() {
		return steamUser;
	}

	/**
	 * @param steamUser the steamUser to set
	 */
	public void setSteamUser(String steamUser) {
		this.steamUser = steamUser;
	}

	/**
	 * @return the party
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * @param party the party to set
	 */
	public void setParty(Party party) {
		this.party = party;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	/**
	 * @return the messages
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Message")
	public List<Message> getMessages() {
		return messages;
	}
}