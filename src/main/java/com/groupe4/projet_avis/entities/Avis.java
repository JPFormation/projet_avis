package com.groupe4.projet_avis.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Getter
@Setter
public class Avis {

    /**
     * Default constructor
     */
    public Avis() {
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
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "moderateur_id")
    private Moderateur moderateur;

    /**
     * 
     */
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "jeu_id")
    private Jeu jeu;


    /**
     * 
     */
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;

}