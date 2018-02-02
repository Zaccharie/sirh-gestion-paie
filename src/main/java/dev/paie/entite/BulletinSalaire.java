package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BulletinSalaire {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private BigDecimal primeExceptionnelle;

	@ManyToOne
	@JoinColumn(name="EMPLOYE_ID")
	private RemunerationEmploye remunerationEmploye;
	
	@ManyToOne
	@JoinColumn(name="PERIODE_ID")
	private Periode periode;
	
	//constructor
	public BulletinSalaire() {
		
	}
	
	//getters and setters
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
