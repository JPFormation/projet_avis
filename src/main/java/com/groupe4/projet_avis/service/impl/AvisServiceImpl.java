package com.groupe4.projet_avis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupe4.projet_avis.entities.Avis;
import com.groupe4.projet_avis.exceptions.AvisNotFoundException;
import com.groupe4.projet_avis.repository.AvisRepository;
import com.groupe4.projet_avis.service.AvisService;

@Service
public class AvisServiceImpl implements AvisService {

	private AvisRepository avisRepository;

	@Autowired
	public AvisServiceImpl(AvisRepository avisRepository) {
		this.avisRepository = avisRepository;

	}

	@Override
	public Avis saveAvis(Avis avis) {
		return this.avisRepository.save(avis);
	}

	@Override
	public List<Avis> getAllAvis() {
		return this.avisRepository.findAll();
	}

	@Override
	public Optional<Avis> getOneAvis(Long id) throws AvisNotFoundException {
		Optional<Avis> avis = this.avisRepository.findById(id);
		if (!avis.isPresent()) {
			throw new AvisNotFoundException(String.format("Avis with id %s not found " + id));
		}
		return this.avisRepository.findById(id);

	}

	@Override
	public Avis updateAvis(Avis avis, long id) throws AvisNotFoundException {
		Optional<Avis> avisExist = this.avisRepository.findById(id);
		if (!avisExist.isPresent()) {
			throw new AvisNotFoundException(String.format("Avis with id %s not found" + id));
		}
		return this.avisRepository.save(avis);

	}

	@Override
	public void removeAvis(Long id) throws AvisNotFoundException {
		Optional<Avis> avis = this.avisRepository.findById(id);
		if (!avis.isPresent()) {
			throw new AvisNotFoundException(String.format("Avis with id %s not found " + id));
		}
		this.avisRepository.delete(avis.get());
	}

}
