package com.groupe4.projet_avis.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;

import com.groupe4.projet_avis.entities.Avis;
import com.groupe4.projet_avis.entities.Classification;
import com.groupe4.projet_avis.entities.Editeur;
import com.groupe4.projet_avis.entities.Genre;
import com.groupe4.projet_avis.entities.Jeu;
import com.groupe4.projet_avis.entities.Joueur;
import com.groupe4.projet_avis.entities.ModelEconomique;
import com.groupe4.projet_avis.entities.Moderateur;
import com.groupe4.projet_avis.entities.Plateforme;
import com.groupe4.projet_avis.service.AvisService;
import com.groupe4.projet_avis.service.JeuService;
import com.groupe4.projet_avis.service.JoueurService;
import com.groupe4.projet_avis.service.ModerateurService;

@Controller
public class InitController {
	private final JoueurService joueurService;
	private final ModerateurService moderateurService;
	private final JeuService jeuService;
	private final AvisService avisService;

	public InitController(JoueurService joueurService, ModerateurService moderateurService, JeuService jeuService,
			AvisService avisService) {
		super();
		this.joueurService = joueurService;
		this.moderateurService = moderateurService;
		this.jeuService = jeuService;
		this.avisService = avisService;
	}

	@PostConstruct
	private void init() {
		Joueur j1 = new Joueur();
		j1.setPseudo("tom cat");
		j1.setMotDePasse("azerty");
		j1.setEmail("tom@mail.com");
		j1.setDateDeNaissance(LocalDate.of(1950, 6, 16));

		Joueur j2 = new Joueur();
		j2.setPseudo("jerry mouse");
		j2.setMotDePasse("qsdfgh");
		j2.setEmail("jerry@mail.com");
		j2.setDateDeNaissance(LocalDate.of(1960, 6, 16));

		Moderateur mod1 = new Moderateur();
		mod1.setPseudo("mickey mouse");
		mod1.setMotDePasse("poiuyt");
		mod1.setEmail("mickey@mail.com");
		mod1.setNumeroDeTelephone("0612345678");

		Moderateur mod2 = new Moderateur();
		mod2.setPseudo("donald duck");
		mod2.setMotDePasse("mlkjhg");
		mod2.setEmail("donald@mail.com");
		mod2.setNumeroDeTelephone("0698765432");

		// créer genres
		Genre t1 = new Genre();
		t1.setNom("Shooting");
		Genre t2 = new Genre();
		t2.setNom("Racing");

		// créer classifications
		Classification c1 = new Classification();
		c1.setNom("PEGI-12");
		Classification c2 = new Classification();
		c2.setNom("PEGI-16");

		// créer plateformes
		Plateforme p1 = new Plateforme();
		p1.setNom("PlayStation");
		Plateforme p2 = new Plateforme();
		p2.setNom("Xbox");

		// créer modelEconomique
		ModelEconomique m1 = new ModelEconomique();
		m1.setNom("free to play");
		ModelEconomique m2 = new ModelEconomique();
		m2.setNom("pay to play");

		// créer éditeurs
		Editeur e1 = new Editeur();
		e1.setNom("Activision");
		Editeur e2 = new Editeur();
		e2.setNom("Sierra");
		
		// créer jeux
		Jeu g1 = new Jeu();
		g1.setNom("Medal of Honour");
		g1.setEditeur(e1);
		g1.setGenre(t1);
		g1.setModeleEconomique(m1);
		g1.setClassification(c2);
		Set<Plateforme> ps1 = new HashSet<>();
		ps1.add(p1);
		ps1.add(p2);
		g1.setPlateformes(ps1);
		//----------
		Jeu g2 = new Jeu();
		g2.setNom("Need for Speed");
		g2.setEditeur(e2);
		g2.setGenre(t2);
		g2.setModeleEconomique(m2);
		g2.setClassification(c1);
		Set<Plateforme> ps2 = new HashSet<>();
		ps1.add(p2);
		g2.setPlateformes(ps2);
		
		// créer avis
		Avis a1 = new Avis();
		a1.setDescription("World war 2 based game");
		a1.setDateEnvoi(LocalDateTime.now());
		a1.setJeu(g1);
		a1.setJoueur(j2);
		a1.setNote(19.0F);
		
		Avis a2 = new Avis();
		a2.setDescription("Race cars in exotic locations");
		a2.setDateEnvoi(LocalDateTime.now());
		a2.setJeu(g2);
		a2.setJoueur(j1);
		a2.setNote(17F);

		if (joueurService.getAllJoueurs().isEmpty()) {
			joueurService.saveJoueur(j1);
			joueurService.saveJoueur(j2);
		}

		if (moderateurService.getAllModerateurs().isEmpty()) {
			moderateurService.saveModerateur(mod1);
			moderateurService.saveModerateur(mod2);
		}

		if (jeuService.getAllJeux().isEmpty()) {
			jeuService.saveJeu(g1);
			jeuService.saveJeu(g2);
		}

		if (avisService.getAllAvis().isEmpty()) {
			avisService.saveAvis(a1);
			avisService.saveAvis(a2);
			
		}
	}

}
