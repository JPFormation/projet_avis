package com.groupe4.projet_avis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupe4.projet_avis.entities.Moderateur;
import com.groupe4.projet_avis.exceptions.ModerateurNotFoundException;
import com.groupe4.projet_avis.repository.ModerateurRepository;
import com.groupe4.projet_avis.service.ModerateurService;

/**
 *
 */
@Service
public class ModerateurServiceImpl implements ModerateurService {
	/**
	 * 
	 */
	private ModerateurRepository moderateurRepository;

	/**
	 * 
	 * @param moderateur
	 */
	@Autowired
	public ModerateurServiceImpl(ModerateurRepository moderateurRepository) {
		this.moderateurRepository = moderateurRepository;
	}

	/**
	 * Create(persister) un moderateur
	 * 
	 * @param Moderateur
	 * @return
	 */
	@Override
	public Moderateur saveModerateur(Moderateur moderateur) {

		/**
		 * 
		 */
		return this.moderateurRepository.save(moderateur);

	}

	/**
	 * Recupere la liste des moderateurs
	 */
	@Override
	public List<Moderateur> getAllModerateurs() {

		/**
		 * 
		 */
		return this.moderateurRepository.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ModerateurNotFoundException
	 */
	@Override
	public Optional<Moderateur> getOneModerateur(Long id) throws ModerateurNotFoundException {

		/**
		 * 
		 * 
		 */
		Optional<Moderateur> moderateur = this.moderateurRepository.findById(id);

		/**
		 * 
		 */
		if (!moderateur.isPresent()) {
			throw new ModerateurNotFoundException(String.format("Moderateur with id %s not found " + id));

		}

		/**
		 * 
		 */
		return this.moderateurRepository.findById(id);

	}

	/**
	 * 
	 * @param Moderateur
	 * @param id
	 * @return
	 * @throws ModerateurNotFoundException
	 */
	@Override
	public Moderateur updateModerateur(Moderateur moderateur, Long id) throws ModerateurNotFoundException {

		/**
		 * 
		 */
		Optional<Moderateur> moderateurExist = this.moderateurRepository.findById(id);

		/**
		 * 
		 */
		if (!moderateurExist.isPresent()) {
			throw new ModerateurNotFoundException(String.format(" Moderateur with id %s not found" + id));

		}

		/**
		 * 
		 */
		return this.moderateurRepository.save(moderateur);
	}

	/**
	 * Delete Moderateur
	 */
	@Override
	public void removeModerateur(Long id) throws ModerateurNotFoundException {

		/**
		 * 
		 */
		Optional<Moderateur> moderateur = this.moderateurRepository.findById(id);

		/**
		 * 
		 */
		if (!moderateur.isPresent()) {
			throw new ModerateurNotFoundException(String.format("Moderateur with id %s not found " + id));

		}

		/**
		 * 
		 */
		this.moderateurRepository.delete(moderateur.get());
	}
}
