package com.groupe4.projet_avis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 */
@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur {

	/**
	 * Default constructor
	 */
	public Utilisateur() {
	}

	/**
	 * 
	 * @param pseudo
	 * @param motDePasse
	 * @param email
	 */
	public Utilisateur(String pseudo, String motDePasse, String email) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.email = email;
	}

	/**
	 * 
	 * @param id
	 * @param pseudo
	 * @param motDePasse
	 * @param email
	 */
	public Utilisateur(Long id, String pseudo, String motDePasse, String email) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.email = email;
	}

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/**
	 * 
	 */
	protected String pseudo;

	/**
	 * 
	 */
	protected String motDePasse;

	/**
	 * 
	 */
	protected String email;

}