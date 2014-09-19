package com.films.gestion;

import java.util.Date;
import java.util.List;

import com.films.*;

public interface Gestionnaire {
	
	// * * * OPERATIONS SUR LES ACTEURS * * *
	
	//Liste de tous les acteurs
	List<Acteur> listActeurs();
	
	//Recherche d'un acteur à partir de son nom
	Acteur getActeurbyName(String nom);
	
	//Créer un acteur
	boolean createActor(String prenom, String nom, String nationnalite, Date date);

	
	// * * * OPERATIONS SUR LES REALISATEURS * * *
	
	//Liste des réalisateurs
	List<Realisateur> listRealisateurs();
	
	//Recherche d'un réalisateur à partir de son nom
	Realisateur getRealbyName(String nom);

	//Créer un realisateur
	boolean createRealisator(String prenom, String nom, String nationnalite, Date date);
	
	
	// * * * OPERATIONS SUR LES FILMS * * *
	
	//Liste des films
	List<Film> listFilms();
	
	//Recherche d'un film à partir du titre
	Film getFilmbyTitre(String titre);
	
	//créer un film
	boolean createfilm(String titre, Date annee, Realisateur Realisateur_Id, Acteur acteur_Id, Acteur acteur_Id2, Acteur acteur_Id3);

	//Film getFilmbyActeur(int idActeur);

	
}
