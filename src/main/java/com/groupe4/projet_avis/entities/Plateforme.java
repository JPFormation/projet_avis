package com.groupe4.projet_avis.entities;

import java.util.Set;

import javax.persistence.Entity;

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
    private Long id;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private Set<Jeu> jeux;

}