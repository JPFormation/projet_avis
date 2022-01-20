package com.groupe4.projet_avis.entities;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Joueur extends Utilisateur {

    /**
     * Default constructor
     */
    public Joueur() {
    }

    /**
     * 
     */
    private LocalDate dateDeNaissance;

    /**
     * 
     */
    private Set<Avis> avis;

}