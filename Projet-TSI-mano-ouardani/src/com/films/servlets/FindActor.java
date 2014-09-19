package com.films.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.films.Acteur;
import com.films.model.Database;

/**
 * Servlet implementation class FindActor
 */
public class FindActor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindActor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Nouvelle instance de database pour effectuer les recherches sur la base
		Database db = new Database();
		
		// Récupère le nom recherché (champs texte du formulaire
		String name = request.getParameter("name");
		
		try {
			// Nouvel acteur dans lequel on met le résultat
			Acteur currentActor = db.getActeurbyName(name);
			
			//System.out.println(currentName.toString());
			
			// Stocke l'acteur.toString dans un attribut "nameactor"
			request.setAttribute("nameactor", currentActor.toString());
			
			// Envoie le résultat dans DisplayActorResult.jsp
			request.getRequestDispatcher("/Acteur/DisplayActorResult.jsp").forward(request, response);
		}
		catch(Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<a href=\"./DisplayActorForm.jsp\">Impossible. Rechercher un autre acteur</a>"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On crée une nouvelle instance de Database pour effectuer les opérations sur la base
    	Database db = new Database();
    	
		// On récupère le nom recherché (champs texte du formulaire)
		String name = request.getParameter("name");
		
		// si le champs texte n'est pas vide
	    if(!name.isEmpty()) {
	    	
			Acteur currentActor = db.getActeurbyName(name);
	    	
	    	//System.out.println(currentActor.getName());
	    	
			// On stocke le nom de l'acteur dans un attribut "DisplayActorResult"
			request.setAttribute("DisplayActorResult", currentActor.getNom());

	  	    // Envoie le résultat dans DisplayActorResult.jsp	    	
	    	//request.getRequestDispatcher("/DisplayActorResult.jsp").forward(request, response);
	    	
	    }
	}

}
