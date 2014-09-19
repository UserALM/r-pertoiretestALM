package com.films;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Acteur")
public class Acteur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Acteur_Id")
	private int acteur_id;
	@Column(name="Nom")
	private String nom;
	@Column(name="Prenom")
	private String prenom;
	@Column(name="Nationnalite")
	private String nationnalite;
	@Column(name="DateNaissance")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@OneToMany(mappedBy="Acteur_Id")
	 private Collection <Film> filmListByAct;
	
	public Acteur(String nom, String prenom, String nationnalite,
			Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nationnalite = nationnalite;
		this.dateNaissance = dateNaissance;
	}
	
	public Acteur() {
		
	}

	public int getActeur_id() {
		return acteur_id;
	}

	public void setActeur_id(int acteur_id) {
		this.acteur_id = acteur_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return " Id: " + acteur_id + "<br>" + prenom + " " + nom + "<br>" + nationnalite
				+ "<br>" + "né(e) le: " + dateNaissance + "<br>" ;
	}
	
	
	
	
	
}
