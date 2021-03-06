package com.labo.rech.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("et")

public class Etudiant  extends Membre{
	private Date dateInscription;
	private String diplome;
	
	@ManyToOne(cascade=CascadeType.ALL )
	private EnseignantChercheur enseignant;

	public Etudiant(Date dateInscription, String diplome, EnseignantChercheur enseignant) {
		super();
		this.dateInscription = dateInscription;
		this.diplome = diplome;
		this.enseignant = enseignant;
	}

	/**
	 * @return the dateInscription
	 */
	public Date getDateInscription() {
		return dateInscription;
	}

	/**
	 * @param dateInscription the dateInscription to set
	 */
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	/**
	 * @return the diplome
	 */
	public String getDiplome() {
		return diplome;
	}

	/**
	 * @param diplome the diplome to set
	 */
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	/**
	 * @return the enseignant
	 */
	public EnseignantChercheur getEnseignant() {
		return enseignant;
	}

	/**
	 * @param enseignant the enseignant to set
	 */
	public void setEnseignant(EnseignantChercheur enseignant) {
		this.enseignant = enseignant;
	}
	

}
