package com.groupe4.projet_avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupe4.projet_avis.entities.Jeu;

/**
 * 
 */
@Repository
public interface JeuRepository extends JpaRepository<Jeu, Long> {

}
