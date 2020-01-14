package com.labo.rech.entity;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ec")
public class EnseignantChercheur extends Membre {

private String grade;
private String etablissement;

@OneToMany(mappedBy="enseignant",fetch=FetchType.LAZY)
private  Collection <Etudiant> etudiants;

public EnseignantChercheur() {
	super();
	// TODO Auto-generated constructor stub
}



public EnseignantChercheur(String grade, String etablissement, Collection<Etudiant> etudiants) {
	super();
	this.grade = grade;
	this.etablissement = etablissement;
	this.etudiants = etudiants;
}



/**
 * @return the grade
 */
public String getGrade() {
	return grade;
}

/**
 * @param grade the grade to set
 */
public void setGrade(String grade) {
	this.grade = grade;
}

/**
 * @return the etablissement
 */
public String getEtablissement() {
	return etablissement;
}

/**
 * @param etablissement the etablissement to set
 */
public void setEtablissement(String etablissement) {
	this.etablissement = etablissement;
}

/**
 * @return the etudiants
 */
public Collection<Etudiant> getEtudiants() {
	return etudiants;
}

/**
 * @param etudiants the etudiants to set
 */
public void setEtudiants(Collection<Etudiant> etudiants) {
	this.etudiants = etudiants;
}



}
