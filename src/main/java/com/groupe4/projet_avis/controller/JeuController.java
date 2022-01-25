package com.groupe4.projet_avis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.groupe4.projet_avis.entities.Jeu;
import com.groupe4.projet_avis.exceptions.JeuNotFoundException;
import com.groupe4.projet_avis.service.JeuService;

/**
 * 
 *
 */
@RestController
@RequestMapping(path = "/api", name = "app_jeux") // prefixe general:localHost/api/jeux/
public class JeuController {

	/**
	 * 
	 */
	private JeuService jeuService;

	/**
	 * 
	 * @param jeuService
	 */
	@Autowired
	public JeuController(JeuService jeuService) {
		this.jeuService = jeuService;
	}

	/**
	 * 
	 * @param jeu
	 * @return
	 */
	@PostMapping(path = "/jeux", name = "create")
	@ResponseStatus(HttpStatus.CREATED) // code 201
	public Jeu add(@RequestBody Jeu jeu) {
		return this.jeuService.saveJeu(jeu);

	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(path = "/jeux", name = "List")
	@ResponseStatus(HttpStatus.OK) // code http 200
	public List<Jeu> list() {
		return this.jeuService.getAllJeux();

	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws JeuNotFoundException
	 */
	@GetMapping(path = "/jeux/{id}", name = "")
	@ResponseStatus(HttpStatus.OK) // code http 200
	public Optional<Jeu> read(@PathVariable Long id) throws JeuNotFoundException {
		return this.jeuService.getOneJeu(id);
	}

	/**
	 * 
	 * @param jeu
	 * @param id
	 * @return
	 * @throws JeuNotFoundException
	 */
	@PutMapping(path = "/jeux/{id}", name = "update")
	@ResponseStatus(HttpStatus.OK) // code
	public Jeu update(@RequestBody Jeu jeu, @PathVariable Long id) throws JeuNotFoundException {
		return this.jeuService.updateJeu(jeu, id);
	}

	/**
	 * 
	 * @param id
	 * @throws JeuNotFoundException
	 */
	@DeleteMapping(path = "/jeux/{id}", name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT) // code
	public void remove(@PathVariable Long id) throws JeuNotFoundException {
		this.jeuService.removeJeu(id);
	}
}
