package com.films.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.films.Acteur;
import com.films.Film;
import com.films.Realisateur;
import com.films.gestion.Gestionnaire;
import com.films.view.SpringContext;


public class Database implements Gestionnaire {

	public Database() {
		super();
	}

	@Override 
	@SuppressWarnings("unchecked")
	public List<Acteur> listActeurs() {
		Query q =  SpringContext.getEm().createQuery("Select a from Acteur a");
		List<Acteur> acteurs = q.getResultList();
     	System.out.println(acteurs.toString());
		return acteurs;
	}

	@Override
	public Acteur getActeurbyName(String nom) {
		try{
			Query q = SpringContext.getEm().createQuery("Select a from Acteur a Where a.nom=:nom");
			q.setParameter("nom", nom);   
			Acteur acteur = (Acteur)q.getSingleResult();
	     	System.out.println(acteur.toString());
			return acteur;
		} 
		catch(Exception e) {
			return null;
		}		
	} 

	@Override
	public List<Realisateur> listRealisateurs() {
		Query q =  SpringContext.getEm().createQuery("Select r from Realisateur r");
		@SuppressWarnings("unchecked")
		List<Realisateur> realisateurs = q.getResultList();
     	System.out.println(realisateurs.toString());
		return realisateurs;
	}

	@Override
	public Realisateur getRealbyName(String nom) {
		try {
			Query q = SpringContext.getEm().createQuery("Select r from Realisateur r Where r.nom=:nom");
			q.setParameter("nom", nom);   
			Realisateur realisateur = (Realisateur)q.getSingleResult();
	     	System.out.println(realisateur.toString());
			return realisateur;
		} 
		catch(Exception e) {
			return null;
		}		
	}

	@Override
	public List<Film> listFilms() {
		Query q =  SpringContext.getEm().createQuery("Select f from Film f");
		@SuppressWarnings("unchecked")
		List<Film> films = q.getResultList();
     	System.out.println(films.toString());
		return films;
	}

	@Override
	public Film getFilmbyTitre(String titre) {
		try{
		Query q = SpringContext.getEm().createQuery("Select f from Film f Where f.titre=:titre");
		q.setParameter("titre", titre);   
		Film film = (Film)q.getSingleResult();
     	System.out.println(film.toString());
		return film;
		} 
		catch(Exception e) {
			return null;
		}		
	}
	
	/* @Override
	public Film getFilmbyActeurs(String titre) {
		try{
		Query q = SpringContext.getEm().createQuery("Select f from Film f Where f.titre=:titre");
		q.setParameter("titre", titre);   
		Film film = (Film)q.getSingleResult();
     	System.out.println(film.toString());
		return film;
		} 
		catch(Exception e) {
			return null;
		}	
	}*/

	@Override
	public boolean createActor(String prenom, String nom, String nationnalite, Date date) {
		
		// On cr�e une nouvelle instance de Database pour effectuer les op�rations sur la base
    	//Database db = new Database();
		
	   	EntityTransaction tx = SpringContext.getEm().getTransaction();
		tx.begin();
			
		// Cr�er un acteur � partir des param�tres
    	Acteur currentActor = new Acteur(nom, prenom, nationnalite, date);	

    	// si les param�tres ne sont pas vides
	    if(prenom!=null && nom!=null && nationnalite!=null && date!=null) {	
    	
	    	// Cr�er un acteur test pour comparer l'acteur r�cup�r� par les param�tres
	    	Acteur testActor =  this.getActeurbyName(currentActor.getNom());
		    	
	    	// Si l'acteur n'existe pas, on le cr�e et renvoie false
			if (testActor == null) {
					SpringContext.getEm().persist(currentActor);
					tx.commit();
					return false;					
			}
			else {
				tx.commit();
				return true;					
		    }
				
    	}
	    
	    // Si certains param�tres sont vides
		tx.commit();
		return true;	
	}

	@Override
	public boolean createRealisator(String prenom, String nom, String nationnalite, Date date) {
		
		// On cr�e une nouvelle instance de Database pour effectuer les op�rations sur la base
    	//Database db = new Database();
		
	   	EntityTransaction tx = SpringContext.getEm().getTransaction();
		tx.begin();
			
		// Cr�er un acteur � partir des param�tres
    	Realisateur currentRealisator = new Realisateur(nom, prenom, nationnalite, date);	

    	// si les param�tres ne sont pas vides
	    if(prenom!=null && nom!=null && nationnalite!=null && date!=null) {	
	    	
	    	// Cr�er un acteur test pour comparer l'acteur r�cup�r� par les param�tres
	    	Realisateur testRealisator =  this.getRealbyName(currentRealisator.getNom());
		    	
	    	// Si l'acteur n'existe pas, on le cr�e et renvoie false
			if (testRealisator == null) {
					SpringContext.getEm().persist(currentRealisator);
					tx.commit();
					return false;					
			}
			else {
				tx.commit();
				return true;					
		    }				
    	}
	    
	    // Si certains param�tres sont vides
		tx.commit();
		return true;
	}	
	
	
public boolean createfilm(String titre, Date annee, Realisateur realisateur, Acteur acteur1, Acteur acteur2, Acteur acteur3) {
		
		// On cr�e une nouvelle instance de Database pour effectuer les op�rations sur la base
    	//Database db = new Database();
		
	   	EntityTransaction tx = SpringContext.getEm().getTransaction();
		tx.begin();
			
		// Cr�er un film � partir des param�tres
    	Film currentFilm = new Film(titre, annee, realisateur, acteur1, acteur2, acteur3);	

    	// si les param�tres ne sont pas vides
	    if(titre!=null && annee!=null && realisateur!=null && acteur1!=null && acteur2!=null && acteur3!=null) {	
	    	
	    	// Cr�er un film test pour comparer l'acteur r�cup�r� par les param�tres
	    	Film testFilm =  this.getFilmbyTitre(currentFilm.getTitre());
		    	
	    	// Si le film n'existe pas 
			if (testFilm == null) {
				
				// Si le r�alisateur est inconnu, on le cr�e
				//if ()
				
				// Si les acteurs sont inconnus, on les cr�e
				
				// On cr�e le film et on renvoie false
				SpringContext.getEm().persist(currentFilm);
				tx.commit();
				return false;					
			}
			else {
				tx.commit();
				return true;					
		    }				
    	}
	    
	    // Si certains param�tres sont vides
		tx.commit();
		return true;
	}	


}
