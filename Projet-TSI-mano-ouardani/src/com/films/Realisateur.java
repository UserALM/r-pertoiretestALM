package com.films;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Realisateur")
public class Realisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Realisateur_Id")
	private int realisateur_id;
	@Column(name="Nom")
	private String nom;
	@Column(name="Prenom")
	private String prenom;
	@Column(name="Nationnalite")
	private String nationnalite;
	@Column(name="DateNaissance")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	/*liaisons entre la table product in stock et product order */
	 @OneToMany(mappedBy="Realisateur_Id")
	 private Collection <Film> filmListByReal;
	
	public Realisateur(String nom, String prenom, String nationnalite,
			Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nationnalite = nationnalite;
		this.dateNaissance = dateNaissance;
	}
	
	public Realisateur() {
		
	}

	public int getRealisateur_id() {
		return realisateur_id;
	}

	public void setRealisateur_id(int realisateur_id) {
		this.realisateur_id = realisateur_id;
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
		return " Id: " + realisateur_id + "<br>" + prenom + " " + nom + "<br>" + nationnalite
				+ "<br>" + "né(e) le: " + dateNaissance + "<br>" ;
	}

	
}
