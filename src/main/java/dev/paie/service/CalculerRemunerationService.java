package dev.paie.service;

import java.util.HashMap;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

public interface CalculerRemunerationService {
	
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);
	
	HashMap<BulletinSalaire, ResultatCalculRemuneration> createHashMapBulletinSalaire();
	
	HashMap<BulletinSalaire, ResultatCalculRemuneration> createHashMapBulletinSalaire(Integer id);
	
}
