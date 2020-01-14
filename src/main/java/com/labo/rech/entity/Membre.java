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
	private String Cin;
	private String Nom;
	private String Prenom;
	
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
	private byte[] Photo;
	private byte[] cv;
	private String Email;
	private String Password;
	
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
	public Membre(String cin, String nom, String prenom, String email) {
		super();
		Cin = cin;
		Nom = nom;
		Prenom = prenom;
		Email = email;
	}
	public void setCv(byte[] cv) {
		this.cv = cv;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCin() {
		return Cin;
	}
	public void setCin(String cin) {
		Cin = cin;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte[] getPhoto() {
		return Photo;
	}
	public void setPhoto(byte[] photo) {
		Photo = photo;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	

}
