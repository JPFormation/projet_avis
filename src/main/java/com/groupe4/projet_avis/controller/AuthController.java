package com.groupe4.projet_avis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.groupe4.projet_avis.entities.Joueur;
import com.groupe4.projet_avis.service.JoueurService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AuthController {
	@Autowired
	private JoueurService joueurService;
	
	@PostMapping(value = "/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Joueur register(@RequestBody Joueur joueur) {
		return joueurService.saveJoueur(joueur);
	}
	
	@PostMapping(value = "/login")
	public Joueur login(@RequestBody Joueur joueur) {
		return joueur;
	}
	
	
	
	
}