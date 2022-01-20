package com.groupe4.projet_avis.entities;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class Avis {

    /**
     * Default constructor
     */
    public Avis() {
    }

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private LocalDateTime dateEnvoi;

    /**
     * 
     */
    private Float note;

    /**
     * 
     */
    private LocalDateTime dateModeration;

    /**
     * 
     */
    private Moderateur moderateur;

    /**
     * 
     */
    private Jeu jeu;


    /**
     * 
     */
    private Joueur joueur;

}