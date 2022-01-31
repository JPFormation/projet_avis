package com.groupe4.projet_avis.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.groupe4.projet_avis.entities.Avis;
import com.groupe4.projet_avis.entities.Jeu;
import com.groupe4.projet_avis.entities.Utilisateur;
import com.groupe4.projet_avis.exceptions.AvisNotFoundException;

public interface AvisService {

	/**
	 * Create(persister) un avis
	 */
	Avis saveAvis(Avis avis);

	/**
	 * Récupère la liste des avis
	 * 
	 * @return list des avis
	 */
	List<Avis> getAllAvis();

	/**
	 * Récupère les details d'un avis specifique
	 * 
	 * @throws AvisNotFoundException
	 */
	Optional<Avis> getOneAvis(Long id) throws AvisNotFoundException;

	/**
	 * 
	 * @param avis
	 * @param id
	 * @return
	 * @throws AvisNotFoundException
	 */
	Avis updateAvis(Avis avis, long id) throws AvisNotFoundException;

	List<Avis> avisDateEnvoiAsc();

	List<Avis> avisNomDuJeuAsc();

	List<Avis> avisNomDuJeuDesc();
	
	List<Avis> avisPseudoDuJoueurAsc();
	
	List<Avis> avisPseudoDuJoueurDesc();
	
	List<Avis> avisNoteDesc();


	List<Avis> avisNoteAsc();



	/**
	 * Delete Avis
	 * 
	 * @param id
	 * @throws AvisNotFoundException
	 */
	public void removeAvis(Long id) throws AvisNotFoundException;




}