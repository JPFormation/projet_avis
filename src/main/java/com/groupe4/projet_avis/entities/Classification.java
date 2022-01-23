package com.groupe4.projet_avis.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Getter
@Setter
public class Classification {

    /**
     * Default constructor
     */
    public Classification() {
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
    @OneToMany(mappedBy = "classification")
    private Set<Jeu> jeux;

}