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

import com.films.model.Database;

/**
 * Servlet implementation class CreateRealisator
 */
public class CreateRealisator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRealisator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// On crée une nouvelle instance de Database pour effectuer les opérations sur la base
    	Database db = new Database();
    	
    	PrintWriter out = response.getWriter();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	
		try {				
			// On récupère champs texte du formulaire)
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String nationality = request.getParameter("nationality");
			Date date = formatter.parse(request.getParameter("date"));

	    	// si les champs texte ne sont pas vides
		    if(!firstname.isEmpty() && !lastname.isEmpty() && !nationality.isEmpty() && date!=null) {	
	    	
		    	// Vrai si l'acteur existe déjà, faux sinon
		    	boolean exist = db.createRealisator(firstname, lastname, nationality, date);
	    	
				if (!exist) {	
					// Afficher la confirmation de création
					request.getRequestDispatcher("/Realisateur/confirmRealisator.jsp").forward(request, response);
				}
				else {
			    	// Affiche un message d'erreur s'il existe déjà avec un lien vers la page de création
					out.println("<a href=\"./NewRealisator.jsp\">Ce réalisateur existe déja.</a>");
			    }
	    	}
		    else {
		    	// Affiche un message d'erreur si certains champs sont vides avec un lien vers la page de création
		    	out.println("<a href=\"./NewRealisator.jsp\">Veuillez remplir tous les champs</a>");
		    }
		} catch (ParseException e) {
			// Affiche un message d'erreur si certains champs sont vides avec un lien vers la page de création
	    	out.println("<a href=\"./NewRealisator.jsp\">Veuillez remplir tous les champs</a>");
		}
	}

}
