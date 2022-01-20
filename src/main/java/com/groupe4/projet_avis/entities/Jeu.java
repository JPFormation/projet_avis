package com.groupe4.projet_avis.entities;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Jeu {

    /**
     * Default constructor
     */
    public Jeu() {
    }

    /**
     * 
     */
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