package com.groupe4.projet_avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupe4.projet_avis.entities.Moderateur;

/**
 *
 */
@Repository
public interface ModerateurRepository extends JpaRepository<Moderateur, Long>{

}
