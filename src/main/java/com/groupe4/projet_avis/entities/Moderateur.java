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
public class Moderateur extends Utilisateur {

    /**
     * Default constructor
     */
    public Moderateur() {
    }

    /**
     * 
     */
    private String numeroDeTelephone;

}