package com.groupe4.projet_avis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupe4.projet_avis.entities.Joueur;
import com.groupe4.projet_avis.exceptions.JoueurNotFoundException;
import com.groupe4.projet_avis.repository.JoueurRepository;
import com.groupe4.projet_avis.service.JoueurService;

/**
 *
 */
@Service
public class JoueurServiceImpl implements JoueurService {

	/**
	 * 
	 */
	private JoueurRepository joueurRepository;

	/**
	 * 
	 * @param joueur
	 * @param joueurRepository 
	 */
	public JoueurServiceImpl(JoueurRepository joueurRepository) {
		this.joueurRepository = joueurRepository;
	}

	/**
	 * 
	 * @param joueur
	 * @return
	 */
	@Override
	public Joueur saveJoueur(Joueur joueur) {

		/**
		 * 
		 */
		return this.joueurRepository.save(joueur);

	}

	/**
	 * 
	 */
	@Override
	public List<Joueur> getAllJoueurs() {

		/**
		 * 
		 */
		return this.joueurRepository.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws JoueurNotFoundException
	 */
	@Override
	public Optional<Joueur> getOneJoueur(Long id) throws JoueurNotFoundException {

		Optional<Joueur> joueur = this.joueurRepository.findById(id);

		if (!joueur.isPresent()) {
			throw new JoueurNotFoundException(String.format("Joueur with id %s not found " + id));

		}
		return this.joueurRepository.findById(id);

	}
	
	/**
	 * 
	 * @param joueur
	 * @param id
	 * @return
	 * @throws JoueurNotFoundException
	 */
	@Override
	public Joueur updateJoueur(Joueur joueur, Long id) throws JoueurNotFoundException {
		Optional<Joueur> joueurExist = this.joueurRepository.findById(id);
		if (!joueurExist.isPresent()) {
			throw new JoueurNotFoundException(String.format(" Joueur with id %s not found" + id));	
		}
		return this.joueurRepository.save(joueur);
	}
	
	@Override
	public void removeJoueur(Long id) throws JoueurNotFoundException {
		Optional<Joueur> joueur = this.joueurRepository.findById(id);
		if (!joueur.isPresent()) {
			throw new JoueurNotFoundException(String.format("Joueur with id %s not found " + id));
		}
		this.joueurRepository.delete(joueur.get());
	}

	@Override
	public Optional<Joueur> getJoueurByPseudo(String pseudo) throws JoueurNotFoundException {
		return Optional.ofNullable(this.joueurRepository.findByPseudo(pseudo));
	}
}
