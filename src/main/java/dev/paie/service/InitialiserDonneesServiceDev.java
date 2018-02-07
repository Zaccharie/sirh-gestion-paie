package dev.paie.service;

import java.time.Year;
import java.util.Map;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.JeuxDonneesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	
	@PersistenceContext private EntityManager em;
	
	@Autowired private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initialiser() {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				JeuxDonneesConfig.class)) {
			
			Map<String, Entreprise> entreprises = context.getBeansOfType(Entreprise.class);
			Map<String, Grade> grades = context.getBeansOfType(Grade.class);
			Map<String, Cotisation> cotisations = context.getBeansOfType(Cotisation.class);
			Map<String, ProfilRemuneration> profilRemunerations = context.getBeansOfType(ProfilRemuneration.class);
			
			cotisations.forEach((k, v) -> {
				em.persist(v);
			});

			entreprises.forEach((k, v) -> {
				em.persist(v);
			});
			
			grades.forEach((k, v) -> {
				em.persist(v);
			});
			
			profilRemunerations.forEach((k, v) -> {
				em.persist(v);
			});
			
			//creation des periodes
			IntStream.rangeClosed(1, 12).forEach(i -> {
				Periode p = new Periode();
				p.setDateDebut(Year.now().atMonth(i).atDay(1));
				p.setDateFin(Year.now().atMonth(i).atEndOfMonth());
				em.persist(p);
			});
			
			//creation d'utilisateurs
			Utilisateur user = new Utilisateur("Zac", passwordEncoder.encode("zac"),true, ROLES.ROLE_ADMINISTRATEUR);
			Utilisateur user2 = new Utilisateur("Jordan", passwordEncoder.encode("jordan"), true, ROLES.ROLE_UTILISATEUR);
			em.persist(user);
			em.persist(user2);
		}

	}

}
