package com.groupe4.projet_avis.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Jeu {

	/**
	 * Default constructor
	 */
	public Jeu() {
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
	private String description;

	/**
	 * 
	 */
	private LocalDate dateSortie;

	/**
	 * 
	 */
	private String image;

	/**
	 * 
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "genre_id")
	private Genre genre;

	/**
	 * 
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "classification_id")
	private Classification classification;

	/**
	 * 
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "editeur_id")
	private Editeur editeur;

	/**
	 * 
	 */
	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(name = "jeu_plateforme", 
	joinColumns = { @JoinColumn(name = "jeu_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "plateforme_id") }
	)
	private Set<Plateforme> plateformes;

	/**
	 * 
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "modeleEconomique_id")
	private ModelEconomique modeleEconomique;

	/**
	 * 
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "moderateur_id")
	private Moderateur moderateur;


    /**
     * 
     */
	@JsonIgnore
	@OneToMany(mappedBy = "jeu", cascade = {CascadeType.PERSIST})
    private Set<Avis> avis;

}