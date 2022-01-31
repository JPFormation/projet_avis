package com.groupe4.projet_avis.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Avis {

	/**
	 * Default constructor
	 */
	public Avis() {
	}

	/**
	 * Constructeur pour la création d'un avis 
	 * 
	 * @param description
	 * @param dateEnvoi
	 * @param note
	 * @param dateModeration
	 * @param moderateur
	 * @param jeu
	 * @param joueur
	 */
	public Avis(String description, LocalDateTime dateEnvoi, Float note, LocalDateTime dateModeration,
			Moderateur moderateur, Jeu jeu, Joueur joueur) {
		super();
		this.description = description;
		this.dateEnvoi = dateEnvoi;
		this.note = note;
		this.dateModeration = dateModeration;
		this.moderateur = moderateur;
		this.jeu = jeu;
		this.joueur = joueur;
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
	private String description;

	/**
	 * 
	 */
	@CreationTimestamp
	private LocalDateTime dateEnvoi;

	/**
	 * 
	 */
	private Float note;

	/**
	 * 
	 */
	@UpdateTimestamp
	private LocalDateTime dateModeration;

	/**
	 * 
	 */
	@ManyToOne()
	@JoinColumn(name = "moderateur_id")
	private Moderateur moderateur;

	/**
	 * 
	 */
	@ManyToOne()
	@JoinColumn(name = "jeu_id")
	private Jeu jeu;

	/**
	 * 
	 */
	@ManyToOne()
	private Joueur joueur;

}