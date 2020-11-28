package com.ikram.employers.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;


@Entity
public class Employer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idEmployer;


@NotNull
@Size (min = 4,max = 15)
private String nomEmployer;
@Min(value = 10)
 @Max(value = 10000)
private Double salaire;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateDebut;



@ManyToOne
private Entreprise entreprise;


public Employer() {
super();
}

public Employer( String nomEmployer, Double salaire, Date dateDebut) {
	super();

	this.nomEmployer = nomEmployer;
	this.salaire = salaire;
	this.dateDebut = dateDebut;
	
}

public Entreprise getEntreprise() {
	return entreprise;
}
public void setEntreprise(Entreprise entreprise) {
	this.entreprise = entreprise;
}
public Long getIdEmployer() {
return idEmployer;
}
public String getNomEmployer() {
	return nomEmployer;
}
public void setNomEmployer(String nomEmployer) {
	this.nomEmployer = nomEmployer;
}
public Double getSalaire() {
	return salaire;
}
public void setSalaire(Double salaire) {
	this.salaire = salaire;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public void setIdEmployer(Long idEmployer) {
	this.idEmployer = idEmployer;
}
@Override
public String toString() {
	return "Employer [idEmployer=" + idEmployer + ", nomEmployer=" + nomEmployer + ", salaire=" + salaire
			+ ", dateDebut=" + dateDebut + ", entreprise=" + entreprise + "]";
}


}