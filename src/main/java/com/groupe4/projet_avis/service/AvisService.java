package com.groupe4.projet_avis.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.groupe4.projet_avis.entities.Avis;
import com.groupe4.projet_avis.exceptions.AvisNotFoundException;

public interface AvisService {

	/**
	 * Create(persister) un avis
	 */
	Avis saveAvis(Avis avis);

	/**
	 * Recupere la liste des avis
	 * 
	 * @return list des avis
	 */
	List<Avis> getAllAvis();

	/**
	 * recupere les details d'un avis specifique
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

	List<Avis> avisNoteAsc(Avis avis, Float note);

	List<Avis> avisDateEnvoiDesc(Avis avis, LocalDateTime dateEnvoi);

	/**
	 * Delete Avis
	 * 
	 * @param id
	 * @throws AvisNotFoundException
	 */
	void removeAvis(Long id) throws AvisNotFoundException;

}