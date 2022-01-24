package com.groupe4.projet_avis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupe4.projet_avis.entities.Jeu;
import com.groupe4.projet_avis.exceptions.JeuNotFoundException;
import com.groupe4.projet_avis.repository.JeuRepository;
import com.groupe4.projet_avis.service.JeuService;

/**
 *
 */
@Service
public class JeuServiceImpl implements JeuService {

	/**
	 * 
	 */
	private JeuRepository jeuRepository;

	/**
	 * 
	 * @param jeuRepository
	 */
	public JeuServiceImpl(JeuRepository jeuRepository) {
		this.jeuRepository = jeuRepository;
	}

	/**
	 * 
	 * @param jeu
	 * @return
	 */
	@Override
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
	@Override
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
	@Override
	public Optional<Jeu> getOneJeu(Long id) throws JeuNotFoundException {

		/**
		 * 
		 */
		Optional<Jeu> jeu = this.jeuRepository.findById(id);

		/**
		 * 
		 */
		if (!jeu.isPresent()) {
			throw new JeuNotFoundException(String.format("Jeu with id %s not found " + id));

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
	@Override
	public Jeu updateJeu(Jeu jeu, Long id) throws JeuNotFoundException {

		/**
		 * 
		 */
		Optional<Jeu> jeuExist = this.jeuRepository.findById(id);

		/**
		 * 
		 */
		if (!jeuExist.isPresent()) {
			throw new JeuNotFoundException(String.format("Jeu with id %s not found " + id));

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
	@Override
	public void removeJeu(Long id) throws JeuNotFoundException {

		/**
		 * 
		 */
		Optional<Jeu> jeu = this.jeuRepository.findById(id);

		/**
		 * 
		 */
		if (!jeu.isPresent()) {
			throw new JeuNotFoundException(String.format("Jeu with id %s not found " + id));

		}

		/**
		 * 
		 */
		this.jeuRepository.delete(jeu.get());
	}

}
