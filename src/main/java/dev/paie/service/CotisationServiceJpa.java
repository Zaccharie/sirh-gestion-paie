package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext private EntityManager em;
	
	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		/*
		Cotisation c = em.find(Cotisation.class, cotisation.getId());
		c.setCode(cotisation.getCode());
		c.setTauxPatronal(cotisation.getTauxPatronal());
		c.setTauxSalarial(cotisation.getTauxSalarial());
		*/
		
		em.merge(cotisation);
	}

	@Override
	public List<Cotisation> lister() {
		return (List<Cotisation>) em.createQuery("SELECT co FROM Cotisation co").getResultList();
	}

}
