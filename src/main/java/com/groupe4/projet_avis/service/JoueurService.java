package com.groupe4.projet_avis.service;

import java.util.List;
import java.util.Optional;

import com.groupe4.projet_avis.entities.Joueur;
import com.groupe4.projet_avis.exceptions.JoueurNotFoundException;

public interface JoueurService {

	/**
	 * 
	 * @param joueur
	 * @return
	 */
	Joueur saveJoueur(Joueur joueur);

	/**
	 * 
	 */
	List<Joueur> getAllJoueurs();

	/**
	 * 
	 * @param id
	 * @return
	 * @throws JoueurNotFoundException
	 */
	Optional<Joueur> getOneJoueur(Long id) throws JoueurNotFoundException;

	/**
	 * 
	 * @param joueur
	 * @param id
	 * @return
	 * @throws JoueurNotFoundException
	 */
	Joueur updateJoueur(Joueur joueur, Long id) throws JoueurNotFoundException;

	void removeJoueur(Long id) throws JoueurNotFoundException;

}