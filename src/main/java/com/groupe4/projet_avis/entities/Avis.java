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
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;

}