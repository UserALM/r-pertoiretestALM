package com.films.gestion;

import java.util.Date;
import java.util.List;

import com.films.*;

public interface Gestionnaire {
	
	// * * * OPERATIONS SUR LES ACTEURS * * *
	
	//Liste de tous les acteurs
	List<Acteur> listActeurs();
	
	//Recherche d'un acteur � partir de son nom
	Acteur getActeurbyName(String nom);
	
	//Cr�er un acteur
	boolean createActor(String prenom, String nom, String nationnalite, Date date);

	
	// * * * OPERATIONS SUR LES REALISATEURS * * *
	
	//Liste des r�alisateurs
	List<Realisateur> listRealisateurs();
	
	//Recherche d'un r�alisateur � partir de son nom
	Realisateur getRealbyName(String nom);

	//Cr�er un realisateur
	boolean createRealisator(String prenom, String nom, String nationnalite, Date date);
	
	
	// * * * OPERATIONS SUR LES FILMS * * *
	
	//Liste des films
	List<Film> listFilms();
	
	//Recherche d'un film � partir du titre
	Film getFilmbyTitre(String titre);
	
	//cr�er un film
	boolean createfilm(String titre, Date annee, Realisateur Realisateur_Id, Acteur acteur_Id, Acteur acteur_Id2, Acteur acteur_Id3);

	//Film getFilmbyActeur(int idActeur);

	
}
