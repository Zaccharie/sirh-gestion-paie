package dev.paie.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.JeuxDonneesConfig;
import dev.paie.entite.Entreprise;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	
	@PersistenceContext private EntityManager em;

	@Override
	@Transactional
	public void initialiser() {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				JeuxDonneesConfig.class)) {
			
			Map<String, Entreprise> entreprises = context.getBeansOfType(Entreprise.class);

			entreprises.forEach((k, v) -> {
				em.persist(v);
			});

		}

	}

}
