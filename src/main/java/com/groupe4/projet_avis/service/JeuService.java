package com.groupe4.projet_avis.service;

import java.util.List;
import java.util.Optional;

import com.groupe4.projet_avis.entities.Jeu;
import com.groupe4.projet_avis.exceptions.JeuNotFoundException;

public interface JeuService {

	/**
	 * 
	 * @param jeu
	 * @return
	 */
	Jeu saveJeu(Jeu jeu);

	/**
	 * 
	 * @return
	 */
	List<Jeu> getAllJeux();

	/**
	 * 
	 * @param id
	 * @return
	 * @throws JeuNotFoundException
	 */
	Optional<Jeu> getOneJeu(Long id) throws JeuNotFoundException;

	/**
	 * 
	 * @param jeu
	 * @param id
	 * @return
	 * @throws JeuNotFoundException
	 */
	Jeu updateJeu(Jeu jeu, Long id) throws JeuNotFoundException;

	/**
	 * 
	 * @param id
	 * @throws JeuNotFoundException
	 */
	void removeJeu(Long id) throws JeuNotFoundException;

}