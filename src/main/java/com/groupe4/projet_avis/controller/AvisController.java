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

import com.groupe4.projet_avis.entities.Avis;
import com.groupe4.projet_avis.exceptions.AvisNotFoundException;
import com.groupe4.projet_avis.service.AvisService;

/**
 * 
 * Annotation:RestController est la combinaison d'annotation Controller et
 * ResponseBody
 *
 * Annotation Controller: specifie à spring que cette classe traite des requetes
 * GET, POST, PUT etc.
 * 
 * Annotation ResponseBody: dit qu'il y aura des reponses(retours) sous format
 * Json qui ne sont pas contenues dans des vues
 */
@RestController
@RequestMapping(path = "/api", name = "app_avis") // prefixe general à toutes routes
public class AvisController {

	/**
	 * Propriete AvisService
	 */
	private AvisService avisService;

	/**
	 * 
	 * Injection via le contructeur
	 * 
	 * Instansiation de la classe AvisService
	 * 
	 * @param avisService
	 */
	@Autowired
	public AvisController(AvisService avisService) {

		this.avisService = avisService;
	}

	/**
	 * ********************************************************************** *
	 * Appuyons nous sur les verbes du protocole http pour realiser le CRUD
	 **************************************************************************
	 */

	/**
	 * 
	 * PostMapping: indique le verbe à partir duquel nous pouvons faire appel à la
	 * methode add en l'occurence ici: POST
	 * 
	 * ResponseStatus: retourne le status de la reponse
	 * 
	 * La methode add: retourne un objet de type Avis
	 * 
	 * RequestBody: On suppose qu'il y a un flux JSON qui va arriver et ce flux va
	 * ettre convertit en objet avis
	 * 
	 * @param avis
	 * @return
	 */
	@PostMapping(path = "/avis", name = "create")
	@ResponseStatus(HttpStatus.CREATED) // code 201
	public Avis add(@RequestBody Avis avis) {
		return this.avisService.saveAvis(avis);
	}

	/**
	 * Recuperation de la liste des avis
	 * 
	 * @return
	 */
	@GetMapping(path = "/avis", name = "List")
	@ResponseStatus(HttpStatus.OK) // code http 200
	public List<Avis> List() {
		return this.avisService.getAllAvis();

	}

	/**
	 * Recuperer un avis specifique
	 * 
	 * @param id
	 * @return
	 * @throws AvisNotFoundException
	 */
	public Optional<Avis> read(@PathVariable Long id) throws AvisNotFoundException {
		return this.avisService.getOneAvis(id);
	}

	/**
	 * Un clent qui arrive sur API fait avec un PUT Http, s'il fait avec la bonne
	 * url, automatiquement le controller va analysé l'url, en fonction de l'url, va
	 * envoyer vers la methode update
	 * 
	 * @param avis
	 * @param id
	 * @return
	 * @throws AvisNotFoundException
	 */
	@PutMapping(path = "/avis/{id}", name = "update")
	@ResponseStatus(HttpStatus.OK) // code
	public Avis update(@RequestBody Avis avis, @PathVariable long id) throws AvisNotFoundException {
		return this.avisService.updateAvis(avis, id);
	}

	/**
	 * Remove permet de supprimer un avis dans la base de données
	 * 
	 * @param id
	 * @throws AvisNotFoundException
	 */
	@DeleteMapping(path = "/avis/{id}", name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT) // code
	public void remove(@PathVariable long id) throws AvisNotFoundException {
		this.avisService.removeAvis(id);
	}

}
