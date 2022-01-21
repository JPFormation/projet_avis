package com.groupe4.projet_avis.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private Genre genre;

    /**
     * 
     */
    private Classification classification;

    /**
     * 
     */
    private Editeur editeur;

    /**
     * 
     */
    private Set<Plateforme> plateformes;

    /**
     * 
     */
    private ModelEconomique modeleEconomique;

    /**
     * 
     */
    private Moderateur moderateur;

    /**
     * 
     */
    private Set<Avis> avis;

}