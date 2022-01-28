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
	@ManyToOne()
	@JoinColumn(name = "genre_id")
	private Genre genre;

	/**
	 * 
	 */
	@ManyToOne()
	@JoinColumn(name = "classification_id")
	private Classification classification;

	/**
	 * 
	 */
	@ManyToOne()
	@JoinColumn(name = "editeur_id")
	private Editeur editeur;

	/**
	 * 
	 */
	@ManyToMany()
	@JoinTable(name = "jeu_plateforme", 
	joinColumns = { @JoinColumn(name = "jeu_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "plateforme_id") }
	)
	private Set<Plateforme> plateformes;

	/**
	 * 
	 */
	@ManyToOne()
	@JoinColumn(name = "modeleEconomique_id")
	private ModelEconomique modeleEconomique;

	/**
	 * 
	 */
	@ManyToOne()
    @JoinColumn(name = "moderateur_id")
	private Moderateur moderateur;


    /**
     * 
     */
	@JsonIgnore
    @OneToMany(mappedBy = "jeu")
    private Set<Avis> avis;

}