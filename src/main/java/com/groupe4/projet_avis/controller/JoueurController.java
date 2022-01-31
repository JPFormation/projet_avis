package com.groupe4.projet_avis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.groupe4.projet_avis.entities.Joueur;
import com.groupe4.projet_avis.exceptions.JoueurNotFoundException;
import com.groupe4.projet_avis.service.JoueurService;

/**
 * 
 *
 */
@RestController
@RequestMapping(path = "/api")
public class JoueurController {
	/**
	 * 
	 */
	@Autowired
	private JoueurService joueurService;

	/**
	 * 
	 * @param joueur
	 * @return
	 */
	@PostMapping(value = "/joueurs")
	@ResponseStatus(HttpStatus.CREATED)
	public Joueur addJoueur(@RequestBody Joueur joueur) {
		return joueurService.saveJoueur(joueur);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws JoueurNotFoundException
	 */
	@GetMapping(value = "/joueurs/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Joueur> getJoueurById(@PathVariable(value = "id") Long id) throws JoueurNotFoundException {
		return joueurService.getOneJoueur(id);
	}

	@GetMapping(value = "/joueurs")
	@ResponseStatus(HttpStatus.OK)
	public List<Joueur> listJoueurs() {
		return this.joueurService.getAllJoueurs();
	}

}
