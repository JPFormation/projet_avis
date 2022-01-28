package com.groupe4.projet_avis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupe4.projet_avis.entities.Jeu;
import com.groupe4.projet_avis.entities.Utilisateur;

/**
 * 
 */
@Repository
public interface JeuRepository extends JpaRepository<Jeu, Long> {
	
	List<Jeu> findAllByOrderByNomAsc();

	List<Jeu> findAllByOrderByNomDesc();

	List<Jeu> findAllByOrderByEditeurIdAsc();

	List<Jeu> findAllByOrderByEditeurIdDesc();

}
