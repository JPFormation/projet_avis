package com.groupe4.projet_avis.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Getter
@Setter
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
    @JsonIgnore
    @OneToMany(mappedBy = "joueur")
    private List<Avis> avis;
 
    /**
     * Méthode permetant d'ajouter un avis dans la liste des avis de ses joueurs
     * @param avis
     * @return
     */
    public List<Avis> addAvis(Avis avis){
    	this.avis.add(avis);
		return this.avis ; 
    	
    }
}