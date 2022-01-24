package com.groupe4.projet_avis.service;

import java.util.List;
import java.util.Optional;

import com.groupe4.projet_avis.entities.Moderateur;
import com.groupe4.projet_avis.exceptions.ModerateurNotFoundException;

public interface ModerateurService {

	/**
	 * 
	 * @param Moderateur
	 * @return
	 */
	Moderateur saveModerateur(Moderateur moderateur);

	/**
	 * 
	 */
	List<Moderateur> getAllModerateurs();

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ModerateurNotFoundException
	 */
	Optional<Moderateur> getOneModerateur(Long id) throws ModerateurNotFoundException;

	/**
	 * 
	 * @param Moderateur
	 * @param id
	 * @return
	 * @throws ModerateurNotFoundException
	 */
	Moderateur updateModerateur(Moderateur Moderateur, Long id) throws ModerateurNotFoundException;

	void removeModerateur(Long id) throws ModerateurNotFoundException;

}