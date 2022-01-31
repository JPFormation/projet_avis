package com.groupe4.projet_avis.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Getter
@Setter
public class Classification {

	/**
	 * Default constructor
	 */
	public Classification() {
	}

	/**
	 * 
	 * @param nom
	 * @param jeux
	 */
	public Classification(String nom, Set<Jeu> jeux) {
		super();
		this.nom = nom;
		this.jeux = jeux;
	}

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 
	 */
	private String nom;

	/**
	 * 
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "classification")
	private Set<Jeu> jeux;

}