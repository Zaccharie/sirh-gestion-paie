package dev.paie.service;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		// TODO set differents champs 
		ResultatCalculRemuneration res = new ResultatCalculRemuneration();
		return res;
	}
	
}
