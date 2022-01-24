package com.groupe4.projet_avis.entities;

import java.util.Set;

import javax.persistence.CascadeType;
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
public class Editeur {

    /**
     * Default constructor
     */
    public Editeur() {
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
    @OneToMany(mappedBy = "editeur", cascade = {CascadeType.PERSIST})
    private Set<Jeu> jeux;

}