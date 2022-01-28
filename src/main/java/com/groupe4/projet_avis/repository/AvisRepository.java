package com.groupe4.projet_avis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupe4.projet_avis.entities.Avis;
import com.groupe4.projet_avis.entities.Jeu;
import com.groupe4.projet_avis.entities.Joueur;
import com.groupe4.projet_avis.entities.Utilisateur;

/**
 * Nous avons une Classe:Avis et le type de l'identifiant:Long en paramettre de
 * l'interface generique JpaRepository
 * 
 * Grace à spring data JPA on peut definir une interface qui va heriter une
 * interface de spring data, à partir de là, spring va s'engeger à generer la
 * classe qui va implementer l'interface
 */
@Repository
public interface AvisRepository extends JpaRepository<Avis, Long> {

//	List<Avis> findAllByOrderByDateEnvoidesc();

	List<Avis> findAllByOrderByDateEnvoiAsc();

	List<Avis> findAllByOrderByJeuIdAsc();

	List<Avis> findAllByOrderByJeuIdDesc();
//
	List<Avis> findAllByOrderByJoueurIdAsc();
//
	List<Avis> findAllByOrderByJoueurIdDesc();

	List<Avis> findAllByOrderByNoteAsc();
//
//	List<Avis> findAllByOrderByNoteDesc();

}
