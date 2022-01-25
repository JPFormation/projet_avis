package com.groupe4.projet_avis.cotroller;

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

import com.groupe4.projet_avis.entities.Joueur;
import com.groupe4.projet_avis.exceptions.JoueurNotFoundException;
import com.groupe4.projet_avis.service.JoueurService;

/**
 * 
 *
 */
@RestController
@RequestMapping(path = "/api", name = "app_joueurs") // prefixe general:localHost/api/joueurs/
public class JoueurController {

	/**
	 * 
	 */
	private JoueurService joueurService;

	/**
	 * 
	 * @param joueurService
	 */
	@Autowired
	public JoueurController(JoueurService joueurService) {
		this.joueurService = joueurService;
	}

	/**
	 * 
	 * @param joueur
	 * @return
	 * 
	 * POST localHost/api/joueurs/
	 * 
	 */
	@PostMapping(path = "/Joueurs", name = "create")
	@ResponseStatus(HttpStatus.CREATED) // code 201
	public Joueur add(@RequestBody Joueur joueur) {
		return this.joueurService.saveJoueur(joueur);
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(path = "/joueurs", name = "List")
	@ResponseStatus(HttpStatus.OK) // code http 200
	public List<Joueur> List() {
		return this.joueurService.getALLJoueurs();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws JoueurNotFoundException
	 */
	@GetMapping(path = "/joueurs/{id}", name = "")
	@ResponseStatus(HttpStatus.OK) // code http 200
	public Optional<Joueur> read(@PathVariable Long id) throws JoueurNotFoundException {
		return this.joueurService.getOneJoueur(id);
	}

	/**
	 * 
	 * @param joueur
	 * @param id
	 * @return
	 * @throws JoueurNotFoundException
	 */
	@PutMapping(path = "/Joueurs/{id}", name = "update")
	@ResponseStatus(HttpStatus.OK) // code
	public Joueur update(@RequestBody Joueur joueur, @PathVariable Long id) throws JoueurNotFoundException {
		return this.joueurService.updateJoueur(joueur, id);
	}

	/**
	 * 
	 * @param id
	 * @throws JoueurNotFoundException
	 */
	@DeleteMapping(path = "/joueurs/{id}", name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT) // code
	public void remove(@PathVariable Long id) throws JoueurNotFoundException {
		this.joueurService.removeJoueur(id);

	}

}
