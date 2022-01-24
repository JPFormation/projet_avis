package com.groupe4.projet_avis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupe4.projet_avis.Exceptions.JeuNotFoundException;
import com.groupe4.projet_avis.entities.Jeu;
import com.groupe4.projet_avis.repository.JeuRepository;

/**
 *
 */
@Service
public class JeuService {

	/**
	 * 
	 */
	private JeuRepository jeuRepository;

	/**
	 * 
	 * @param jeuRepository
	 */
	public JeuService(JeuRepository jeuRepository) {
		this.jeuRepository = jeuRepository;
	}

	/**
	 * 
	 * @param jeu
	 * @return
	 */
	public Jeu saveJeu(Jeu jeu) {

		/**
		 * 
		 */
		return this.jeuRepository.save(jeu);

	}

	/**
	 * 
	 * @return
	 */
	public List<Jeu> getAllJeux() {

		/**
		 * 
		 */
		return this.jeuRepository.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws JeuNotFoundException
	 */
	public Optional<Jeu> getOneJeu(Long id) throws JeuNotFoundException {

		/**
		 * 
		 */
		Optional<Jeu> jeu = this.jeuRepository.findById(id);

		/**
		 * 
		 */
		if (!jeu.isPresent()) {
			throw new JeuNotFoundException(String.format("Jeu with id %s not found, nul" + id));

		}
		/**
		 * 
		 */
		return this.jeuRepository.findById(id);

	}

	/**
	 * 
	 * @param jeu
	 * @param id
	 * @return
	 * @throws JeuNotFoundException
	 */
	public Jeu updateJeu(Jeu jeu, Long id) throws JeuNotFoundException {

		/**
		 * 
		 */
		Optional<Jeu> jeuExist = this.jeuRepository.findById(id);

		/**
		 * 
		 */
		if (!jeuExist.isPresent()) {
			throw new JeuNotFoundException(String.format("Jeu with id %s not found, nul" + id));

		}

		/**
		 * 
		 */
		return this.jeuRepository.save(jeu);

	}

	/**
	 * 
	 * @param id
	 * @throws JeuNotFoundException
	 */
	public void removeJeu(Long id) throws JeuNotFoundException {

		/**
		 * 
		 */
		Optional<Jeu> jeu = this.jeuRepository.findById(id);

		/**
		 * 
		 */
		if (!jeu.isPresent()) {
			throw new JeuNotFoundException(String.format("Jeu with id %s not found, nul" + id));

		}

		/**
		 * 
		 */
		this.jeuRepository.delete(jeu.get());
	}

}
