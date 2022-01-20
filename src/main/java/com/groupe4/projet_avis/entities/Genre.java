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
public class Genre {

    /**
     * Default constructor
     */
    public Genre() {
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