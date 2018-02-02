package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RemunerationEmploye {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String matricule;
	
	@ManyToOne
	@JoinColumn(name="PROFIL_REMUNERATION_ID")
	private ProfilRemuneration profilRemuneration;
	
	@ManyToOne
	@JoinColumn(name="ENTREPRISE_ID")
	private Entreprise entreprise;
	
	@ManyToOne
	@JoinColumn(name="GRADE_ID")
	private Grade grade;
	
	//constructor
	public RemunerationEmploye() {
		
	}
	
	//getters and setters
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
