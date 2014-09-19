package com.films.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.films.Acteur;
import com.films.Film;
import com.films.Realisateur;
import com.films.model.Database;

/**
 * Servlet implementation class CreateFilm
 */
public class CreateFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Database db = new Database();
    	
    	PrintWriter out = response.getWriter();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	
		try {				
			// On récupère champs texte du formulaire (Film - Realisateur - Acteurs)
			String title = request.getParameter("titlefilm");
			Date daterelease = formatter.parse(request.getParameter("daterelease"));
			
			String r_firstname = request.getParameter("r_firstname");
			String r_lastname = request.getParameter("r_lastname");
			String r_nationality = request.getParameter("r_nationality");
			Date r_date = formatter.parse(request.getParameter("r_date"));
			
			String a1_firstname = request.getParameter("a1_firstname");
			String a1_lastname = request.getParameter("a1_lastname");
			String a1_nationality = request.getParameter("a1_nationality");
			Date a1_date = formatter.parse(request.getParameter("a1_date"));
			
			String a2_firstname = request.getParameter("a2_firstname");
			String a2_lastname = request.getParameter("a2_lastname");
			String a2_nationality = request.getParameter("a2_nationality");
			Date a2_date = formatter.parse(request.getParameter("a2_date"));
			
			String a3_firstname = request.getParameter("a3_firstname");
			String a3_lastname = request.getParameter("a3_lastname");
			String a3_nationality = request.getParameter("a3_nationality");
			Date a3_date = formatter.parse(request.getParameter("a3_date"));
			
			// On crée des instances de test pour films, réalisateur et acteurs 
			Realisateur test_r = new Realisateur(r_firstname, r_lastname, r_nationality, r_date);
			Acteur test_a1 = new Acteur(a1_firstname, a1_firstname, a1_nationality, a1_date);
			Acteur test_a2 = new Acteur(a2_firstname, a2_lastname, a2_nationality, a2_date);
			Acteur test_a3 = new Acteur(a3_firstname, a3_lastname, a3_nationality, a3_date);
			Film test_film = new Film(title, daterelease, test_r, test_a1, test_a2, test_a3); 
			


	    	// si les champs textes obligatoires ne sont pas vides
		    if(!title.isEmpty() && daterelease!=null 
			    && !r_firstname.isEmpty() && !r_lastname.isEmpty() 
		    	&& !a1_firstname.isEmpty() && !a1_lastname.isEmpty() 
		    	&& !a2_firstname.isEmpty() && !a2_lastname.isEmpty() 
		    	&& !a3_firstname.isEmpty() && !a3_lastname.isEmpty() ) {	

		    	// Vérifie si le réalisateur existe déjà, le crée sinon	    	
		    	db.createRealisator(r_lastname, r_firstname, r_nationality, r_date);
		    	
		    	
		    	// Vérifie si les acteurs existent déjà, les crée sinon
		    	db.createActor(a1_firstname, a1_lastname, a1_nationality, a1_date);
		    	db.createActor(a2_firstname, a2_lastname, a2_nationality, a2_date);
		    	db.createActor(a3_firstname, a3_lastname, a3_nationality, a3_date);
		    	
		    	// Vrai si le film existe déjà, faux sinon
		    	boolean filmExist = db.createfilm(title, daterelease, test_r, test_a1, test_a2, test_a3);
	    	
				if (filmExist) {	
					// Afficher la confirmation de création
					request.getRequestDispatcher("/Film/NewFilmConfirm.jsp").forward(request, response);
				} 
				else {
			    	// Affiche un message d'erreur s'il existe déjà avec un lien vers la page de création
					out.println("<a href=\"./NewFilm.jsp\">Ce film existe déja.</a>");
			    } 
	    	}
		    else {
		    	// Affiche un message d'erreur si certains champs sont vides avec un lien vers la page de création
		    	out.println("<a href=\"./NewFilm.jsp\">Veuillez remplir tous les champs du film 1</a>");
		    }
		} catch (ParseException e) {
			// Affiche un message d'erreur si certains champs sont vides avec un lien vers la page de création
	    	out.println("<a href=\"./NewFilm.jsp\">Veuillez remplir tous les champs du film 2</a>");
		}
	}
	

}
