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
public class ModelEconomique {

	/**
	 * Default constructor
	 */
	public ModelEconomique() {
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
	@OneToMany(mappedBy = "modeleEconomique")
	private Set<Jeu> jeux;

}