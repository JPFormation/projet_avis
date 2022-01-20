package com.groupe4.projet_avis.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Getter
@Setter
public class Utilisateur {

    /**
     * Default constructor
     */
    public Utilisateur() {
    }

    /**
     * 
     */
    protected Long id;

    /**
     * 
     */
    protected String pseudo;

    /**
     * 
     */
    protected String motDePasse;

    /**
     * 
     */
    protected String email;

}