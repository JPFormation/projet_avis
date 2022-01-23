package com.groupe4.projet_avis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupe4.projet_avis.Exceptions.AvisNotFoundException;
import com.groupe4.projet_avis.entities.Avis;
import com.groupe4.projet_avis.repository.AvisRepository;

/**
 * Annotation service indique à spring qu'il s'agit d'un component et que nous
 * allons faire des traitements metiers dans cette classe
 */
@Service
public class AvisService {
	/**
	 * Propriete de AvisRepository
	 */
	private AvisRepository avisRepository;

	/**
	 * Annotation: Autowired veut dire inject la classe de avisRepository et crée
	 * une instance de celle-ci
	 * 
	 * @param avisRepository
	 */
	@Autowired
	public AvisService(AvisRepository avisRepository) {
		this.avisRepository = avisRepository;

	}

	/**
	 ***************************************************************************** 
	 * Nous allons exposer des traitements
	 * ***************************************************************************
	 * CRUD: Create, Retreave, update, Delete et envoyer la liste des avis
	 * ****************************************************************************
	 */

	/**
	 * Create(persister) un avis
	 */
	public Avis saveAvis(Avis avis) {
		/**
		 * interface avisRepository herite de l'interface JpaRepository qui propose des
		 * methodes come la methode save qui prend en paramettre un objet et permet de
		 * creer un enregistrement dans la base de données. c'est un service fournit par
		 * le framework Hubernate, celui-ci permet d'augmenter la productivité dans la
		 * couche d'accès aux données c'est une implementation de la specification JPA
		 */
		return this.avisRepository.save(avis);

	}

	/**
	 * Recupere la liste des avis
	 * 
	 * @return list des avis
	 */
	public List<Avis> getAllAvis() {
		/**
		 * findAll(): methode permetant de retourner la liste des avis
		 */
		return this.avisRepository.findAll();

	}

	/**
	 * recupere les details d'un avis specifique
	 * 
	 * @throws AvisNotFoundException
	 */
	public Optional<Avis> getOneAvis(Long id) throws AvisNotFoundException {

		/**
		 * Recuperation d'un avis
		 */
		Optional<Avis> avis = this.avisRepository.findById(id);

		/**
		 * Si un avis existe on recupere ce dernier sinon on leve une exception
		 * 
		 * 
		 * 
		 */
		if (!avis.isPresent()) {
			throw new AvisNotFoundException(String.format("Avis with id %s not found " + id));

		}

		/**
		 * Retourne l'avis demandé
		 */
		return this.avisRepository.findById(id);

	}

	/**
	 * 
	 * @param avis
	 * @param id
	 * @return
	 * @throws AvisNotFoundException
	 */
	public Avis updateAvis(Avis avis, long id) throws AvisNotFoundException {
		/**
		 * On verifie d'abord si l'etudiant existe avant de lui mettre dans la base s'il
		 * n'existe pas on lève une exception
		 */
		Optional<Avis> avisExist = this.avisRepository.findById(id);
		if (!avisExist.isPresent()) {
			throw new AvisNotFoundException(String.format("Avis with id %s not found" + id));

		}
		/**
		 * Si l'avis existe on fait la mise à jour methode save: permet ici de créer et
		 * de mmettre à jour verifie: si l'objet contient un id c'est une mise à jour si
		 * l'objet ne conttient pas un id c'est une création d'une nouvelle resource
		 */
		return this.avisRepository.save(avis);

	}

	/**
	 * Delete Avis
	 * 
	 * @param id
	 * @throws AvisNotFoundException
	 */
	public void removeAvis(Long id) throws AvisNotFoundException {
		Optional<Avis> avis = this.avisRepository.findById(id);
		if (!avis.isPresent()) {
			throw new AvisNotFoundException(String.format("Avis with id %s not found " + id));

		}
		this.avisRepository.delete(avis.get());

	}

}
