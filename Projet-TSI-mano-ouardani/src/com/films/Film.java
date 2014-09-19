package com.films;

import java.util.Date;
import javax.persistence.*;


@Entity
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Film_Id")
	private int film_id;
	@Column(name="Film_Titre", nullable=false)
	private String titre;
	//private Realisateur realisateur;
	//private Collection<Acteur> acteurs;
	@Column(name="Film_Annee", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date annee;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	/*L'annotation @JoinColumn, quant à elle, définit la clé étrangère. Ici, la colonne de la table productin stock s'appellera userID */
	//private CustomerInDatabase customerId;
	@JoinColumn(name="Realisateur_Id")
	private Realisateur Realisateur_Id;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	/*L'annotation @JoinColumn, quant à elle, définit la clé étrangère. Ici, la colonne de la table productin stock s'appellera userID */
	//private CustomerInDatabase customerId;
	@JoinColumn(name="Acteur_Id")
	private Acteur Acteur_Id;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	/*L'annotation @JoinColumn, quant à elle, définit la clé étrangère. Ici, la colonne de la table productin stock s'appellera userID */
	//private CustomerInDatabase customerId;
	@JoinColumn(name="Acteur_Id2")
	private Acteur Acteur_Id2;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	/*L'annotation @JoinColumn, quant à elle, définit la clé étrangère. Ici, la colonne de la table productin stock s'appellera userID */
	//private CustomerInDatabase customerId;
	@JoinColumn(name="Acteur_Id3")
	private Acteur Acteur_Id3;
	

	
	
	public Film(String titre, Date annee, Realisateur Realisateur_Id, Acteur acteur_Id, Acteur acteur_Id2, Acteur acteur_Id3) {
		super();
		//this.film_id = film_id;
		this.titre = titre;
		this.annee = annee;
		this.Realisateur_Id = Realisateur_Id;
		this.Acteur_Id = acteur_Id;
		this.Acteur_Id2 = acteur_Id2;
		this.Acteur_Id3 = acteur_Id3;
	}
	
	public Film() {
	
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getAnnee() {
		return annee;
	}

	public void setAnnee(Date annee) {
		this.annee = annee;
	}

	@Override
	public String toString() {
		return "Identifiant" + film_id + "<br>" + titre + "<br>" + "Sorti le:"
				+ annee + "<br>" + "Réalisé par: " + Realisateur_Id.getPrenom() + " " 
				+ Realisateur_Id.getNom() + "<br>" + "Avec " + Acteur_Id.getPrenom() + " "
				+ Acteur_Id.getNom() + ", " + Acteur_Id2.getPrenom() + " " + Acteur_Id2.getNom() + " et "
				+ Acteur_Id3.getPrenom() + " " + Acteur_Id3.getNom();
	}

}
