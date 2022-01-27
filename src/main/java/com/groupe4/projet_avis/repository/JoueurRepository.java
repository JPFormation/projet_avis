package com.groupe4.projet_avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupe4.projet_avis.entities.Joueur;
import com.groupe4.projet_avis.entities.Utilisateur;

/**
 *
 */
@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	public Joueur findByPseudo(String pseudo);
}
