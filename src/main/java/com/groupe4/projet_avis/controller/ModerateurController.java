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

import com.groupe4.projet_avis.entities.Moderateur;
import com.groupe4.projet_avis.exceptions.ModerateurNotFoundException;
import com.groupe4.projet_avis.service.ModerateurService;

/**
 * 
 *
 */
@RestController
@RequestMapping(path = "/api", name = "app_moderateurs") // prefixe general:localHost/api/moderateurs/
public class ModerateurController {

	/**
	 * 
	 */
	private ModerateurService moderateurService;

	/**
	 * 
	 * @param moderateurService
	 */
	@Autowired
	public ModerateurController(ModerateurService moderateurService) {
		this.moderateurService = moderateurService;
	}

	/**
	 * 
	 * @param moderateur
	 * @return
	 */
	@PostMapping(path = "/moderateurs", name = "create")
	@ResponseStatus(HttpStatus.CREATED) // code 201
	public Moderateur add(@RequestBody Moderateur moderateur) {
		return this.moderateurService.saveModerateur(moderateur);

	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(path = "/moderateurs", name = "List")
	@ResponseStatus(HttpStatus.OK) // code http 200
	public List<Moderateur> list() {
		return this.moderateurService.getAllModerateurs();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ModerateurNotFoundException
	 */
	@GetMapping(path = "/moderateurs/{id}", name = "")
	@ResponseStatus(HttpStatus.OK) // code http 200
	public Optional<Moderateur> read(@PathVariable Long id) throws ModerateurNotFoundException {
		return this.moderateurService.getOneModerateur(id);

	}

	/**
	 * 
	 * @param moderateur
	 * @param id
	 * @return
	 * @throws ModerateurNotFoundException
	 */
	@PutMapping(path = "/moderateurs/{id}", name = "update")
	@ResponseStatus(HttpStatus.OK) // code
	public Moderateur update(@RequestBody Moderateur moderateur, @PathVariable Long id)
			throws ModerateurNotFoundException {
		return this.moderateurService.updateModerateur(moderateur, id);

	}

	/**
	 * 
	 * @param id
	 * @throws ModerateurNotFoundException
	 */
	@DeleteMapping(path = "/moderateurs/{id}", name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT) // code
	public void remove(@PathVariable Long id) throws ModerateurNotFoundException {

		this.moderateurService.removeModerateur(id);
	}

}
