package com.groupe4.projet_avis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.groupe4.projet_avis.entities.Moderateur;
import com.groupe4.projet_avis.repository.ModerateurRepository;

@SpringBootTest
class ProjetAvisApplicationTests {

	@Autowired
	private ModerateurRepository repository;

	@Test
	void createModerateur() {
		Moderateur mod = new Moderateur();
		mod.setPseudo("Rishi");
		mod.setMotDePasse("azerty");
		repository.save(mod);
	}
	
	@Test
	public void testFindModById() {
		List<Moderateur> modList = repository.findAll();
		System.out.println(modList);
	}

}
