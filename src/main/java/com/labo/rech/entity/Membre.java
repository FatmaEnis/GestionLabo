package com.labo.rech.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.DiscriminatorType;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_membre",
discriminatorType=DiscriminatorType.STRING,length=2)
public class Membre implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Membre_ID")
	private Integer id;
	private String cin;
	private String nom;
	private String prenom;
	
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
	private byte[] photo;
	private byte[] cv;
	private String email;
	private String password;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Laboratoire laboratoire;
	
	@ManyToMany(mappedBy="membres",cascade=CascadeType.ALL )
	private Set <Publication> publications;
	
	@ManyToMany(mappedBy="membres",cascade=CascadeType.ALL )
	private Set <Evenement> evenements;
	
	@ManyToMany(mappedBy="membres" ,cascade=CascadeType.ALL )
	private Set <Outil> outils;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="MEMBRE_ROLE",joinColumns=@JoinColumn(name="MR_MEMBER_ID"),inverseJoinColumns=@JoinColumn(name="MR_ROLE_ID"))
	private Set <Role> roles;
	
	
	public Membre() {
		super();
	}


	public Membre(String cin, String nom, String prenom, Date date, byte[] photo, byte[] cv, String email,
			String password, Laboratoire laboratoire, Set<Publication> publications, Set<Evenement> evenements,
			Set<Outil> outils, Set<Role> roles) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.photo = photo;
		this.cv = cv;
		this.email = email;
		this.password = password;
		this.laboratoire = laboratoire;
		this.publications = publications;
		this.evenements = evenements;
		this.outils = outils;
		this.roles = roles;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the cin
	 */
	public String getCin() {
		return cin;
	}


	/**
	 * @param cin the cin to set
	 */
	public void setCin(String cin) {
		this.cin = cin;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}


	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	/**
	 * @return the cv
	 */
	public byte[] getCv() {
		return cv;
	}


	/**
	 * @param cv the cv to set
	 */
	public void setCv(byte[] cv) {
		this.cv = cv;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the laboratoire
	 */
	public Laboratoire getLaboratoire() {
		return laboratoire;
	}


	/**
	 * @param laboratoire the laboratoire to set
	 */
	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}


	/**
	 * @return the publications
	 */
	public Set<Publication> getPublications() {
		return publications;
	}


	/**
	 * @param publications the publications to set
	 */
	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}


	/**
	 * @return the evenements
	 */
	public Set<Evenement> getEvenements() {
		return evenements;
	}


	/**
	 * @param evenements the evenements to set
	 */
	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}


	/**
	 * @return the outils
	 */
	public Set<Outil> getOutils() {
		return outils;
	}


	/**
	 * @param outils the outils to set
	 */
	public void setOutils(Set<Outil> outils) {
		this.outils = outils;
	}


	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}


	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Membre other = (Membre) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	

}
