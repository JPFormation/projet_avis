package com.groupe4.projet_avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupe4.projet_avis.entities.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {

}
