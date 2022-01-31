package com.groupe4.projet_avis.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.groupe4.projet_avis.repository.ClassificationRepository;
import com.groupe4.projet_avis.repository.EditeurRepository;
import com.groupe4.projet_avis.repository.GenreRepository;
import com.groupe4.projet_avis.repository.ModeleconomiqueRepository;
import com.groupe4.projet_avis.repository.PlateformeRepository;
import com.groupe4.projet_avis.service.AvisService;
import com.groupe4.projet_avis.service.JeuService;
import com.groupe4.projet_avis.service.JoueurService;
import com.groupe4.projet_avis.service.ModerateurService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class InitController {
	@Autowired
	private JoueurService joueurService;
	@Autowired
	private ModerateurService moderateurService;
	@Autowired
	private JeuService jeuService;
	@Autowired
	private AvisService avisService;
	@Autowired
	private GenreRepository genreService;
	@Autowired
	private ClassificationRepository classificationService;
	@Autowired
	private ModeleconomiqueRepository modeleconomiqueService;
	@Autowired
	private EditeurRepository editeurService;
	@Autowired
	private PlateformeRepository plateformeService;

	@PostConstruct
	private void init() {
		if (joueurService.getAllJoueurs().isEmpty()) {
			Joueur j1 = new Joueur();
			j1.setPseudo("tom cat");
			j1.setMotDePasse("azerty");
			j1.setEmail("tom@mail.com");
			j1.setDateDeNaissance(LocalDate.of(1950, 6, 16));
			joueurService.saveJoueur(j1);

			Joueur j2 = new Joueur();
			j2.setPseudo("jerry mouse");
			j2.setMotDePasse("qsdfgh");
			j2.setEmail("jerry@mail.com");
			j2.setDateDeNaissance(LocalDate.of(1960, 6, 16));
			joueurService.saveJoueur(j2);
		}

		if (moderateurService.getAllModerateurs().isEmpty()) {
			Moderateur m1 = new Moderateur();
			m1.setPseudo("mickey mouse");
			m1.setMotDePasse("poiuyt");
			m1.setEmail("mickey@mail.com");
			m1.setNumeroDeTelephone("0612345678");
			moderateurService.saveModerateur(m1);

			Moderateur m2 = new Moderateur();
			m2.setPseudo("donald duck");
			m2.setMotDePasse("mlkjhg");
			m2.setEmail("donald@mail.com");
			m2.setNumeroDeTelephone("0698765432");
			moderateurService.saveModerateur(m2);
		}

		if (jeuService.getAllJeux().isEmpty()) {

			// créer genres
			Genre t1 = new Genre();
			t1.setNom("Shooting");
			Genre t2 = new Genre();
			t2.setNom("Racing");
			
			
			
			// perister des genres avant de les attribuer à un jeu 
			genreService.save(t1);
			genreService.save(t2);

			// créer classifications
			Classification c1 = new Classification();
			c1.setNom("PEGI-12");
			Classification c2 = new Classification();
			c2.setNom("PEGI-16");
			classificationService.save(c1);
			classificationService.save(c2);


			// créer plateformes
			Plateforme p1 = new Plateforme();
			p1.setNom("PlayStation");
			Plateforme p2 = new Plateforme();
			p2.setNom("Xbox");
			
			// créer avis
			Avis a1 = new Avis();
			a1.setDescription("good");
			a1.setNote(20);
			avisService.saveAvis(a1);
			
			// perister des plateformes avant de les attribuer à un jeu 
			plateformeService.save(p1);
			plateformeService.save(p2);


			// créer modelEconomique
			ModelEconomique m1 = new ModelEconomique();
			m1.setNom("free to play");
			ModelEconomique m2 = new ModelEconomique();
			m2.setNom("pay to play");
			modeleconomiqueService.save(m1);
			modeleconomiqueService.save(m2);
			
			// créer éditeurs
			Editeur e1 = new Editeur();
			e1.setNom("Activision");
			Editeur e2 = new Editeur();
			e2.setNom("Sierra");
			
			// perister des editeurs avant de les attribuer à un jeu 
			editeurService.save(e1);
			editeurService.save(e2);
			

			Jeu g1 = new Jeu();
			g1.setNom("Medal of Honour");
			g1.setEditeur(e1);
			g1.setGenre(t1);
			
			g1.setModeleEconomique(m1);
			g1.setClassification(c2);
			List<Plateforme> ps1 = new ArrayList<>();
			ps1.add(p1);
			ps1.add(p2);
			g1.setPlateformes(ps1);
			jeuService.saveJeu(g1);

			Jeu g2 = new Jeu();
			g2.setNom("Need for Speed");
			g2.setEditeur(e2);
			g2.setGenre(t2);
			g2.setModeleEconomique(m2);
			g2.setClassification(c1);
			
			
			List<Plateforme> ps2 = new ArrayList<>();
			ps1.add(p2);
			g2.setPlateformes(ps2);
			jeuService.saveJeu(g2);
		}

		if (avisService.getAllAvis().isEmpty()) {
			

		}
	}

}
