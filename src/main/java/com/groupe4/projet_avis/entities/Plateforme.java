package com.groupe4.projet_avis.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Getter
@Setter
public class Plateforme {

	/**
	 * Default constructor
	 */
	public Plateforme() {
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
	 * JPA gère les relations many to many en créant une table de jointure
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "plateformes")
	private Set<Jeu> jeux;

}