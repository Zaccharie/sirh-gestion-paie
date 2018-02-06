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

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.util.PaieUtils;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
	
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	
	@Autowired
	private PaieUtils paieUtils;
	
	
	@RequestMapping(method = RequestMethod.GET, path= "/lister")
	public ModelAndView listerEmploye(Model mode) {
		
		ModelAndView mv = new ModelAndView();
		
		List<RemunerationEmploye> employes = remunerationEmployeRepository.findAll();
		
		mv.setViewName("employes/listerEmploye");
		mv.addObject("employes", employes);
		
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye(Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		// Création de l'objet du modèle.
		RemunerationEmploye remuEmploye = new RemunerationEmploye();
		// Liaison du modèle et de l'objet.
		model.addAttribute("remunerationEmploye", remuEmploye);
		
		//Declaration map<Grade, String> pour associer salaire annuelle à un grade
		HashMap<Grade, String> salaireAnnuelles = new HashMap<Grade, String>();
		
		List<Entreprise> entreprises = entrepriseRepository.findAll();
		List<Grade> grades = gradeRepository.findAll();
		List<ProfilRemuneration> profiles = profilRemunerationRepository.findAll();
		
		for(Grade g : grades) {
			salaireAnnuelles.put(g, paieUtils.formaterBigDecimal( (g.getNbHeuresBase().multiply(g.getTauxBase())).multiply(new BigDecimal("12")) ));
		}
			
		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprises", entreprises);
		mv.addObject("salairesAnnuelles", salaireAnnuelles);
		mv.addObject("grades", grades);
		mv.addObject("profiles", profiles);

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path="/creer")
	public String submitForm(@ModelAttribute("remunerationEmploye") RemunerationEmploye remunerationEmploye) {
		if(remunerationEmploye.getMatricule().equals("")) {
			return "redirect:/mvc/employes/creer?errors";
		}
		else {
			remunerationEmployeRepository.save(remunerationEmploye);
			return "redirect:/mvc/employes/lister";
		}


	}
}