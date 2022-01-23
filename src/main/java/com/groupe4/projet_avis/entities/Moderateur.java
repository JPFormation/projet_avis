package com.groupe4.projet_avis.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 */
@Entity
@Getter
@Setter
@ToString(callSuper=true, includeFieldNames=true)
public class Moderateur extends Utilisateur {

    /**
     * Default constructor
     */
    public Moderateur() {
    	super();
    }

    /**
     * 
     */
    private String numeroDeTelephone;

}