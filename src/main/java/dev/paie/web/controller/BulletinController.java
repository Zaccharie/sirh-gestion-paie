package dev.paie.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;


@Controller
@RequestMapping("/bulletins")
public class BulletinController {
	
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	
	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;
	
	@Autowired
	private CalculerRemunerationService calculerRemunerationServiceSimple;
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletins(){
		
		ModelAndView mv = new ModelAndView();
		
		//Declaration map pour associer resultatCalculRemuneration à un bulletin
		HashMap<BulletinSalaire, ResultatCalculRemuneration> buSalaire = calculerRemunerationServiceSimple.createHashMapBulletinSalaire();
			
		mv.setViewName("bulletins/listerBulletins");
		//mv.addObject("bulletins", bulletins);
		mv.addObject("buSalaire", buSalaire);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin(Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		// Création de l'objet du modèle.
		BulletinSalaire bulletin = new BulletinSalaire();
		// Liaison du modèle et de l'objet.
		model.addAttribute("bulletinSalaire", bulletin);
		
		List<RemunerationEmploye> employes = remunerationEmployeRepository.findAll();
		List<Periode> periodes = periodeRepository.findAll();

		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("employes", employes);
		mv.addObject("periodes", periodes);

		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST, path="/creer")
	public String submitForm(@ModelAttribute("bulletinSalaire") BulletinSalaire bulletinSalaire) {
		if(bulletinSalaire.getPrimeExceptionnelle() == null) {
			bulletinSalaire.setPrimeExceptionnelle(new BigDecimal("0"));
		}

		bulletinSalaireRepository.save(bulletinSalaire);
		return("redirect:/mvc/bulletins/lister");
	}


}
