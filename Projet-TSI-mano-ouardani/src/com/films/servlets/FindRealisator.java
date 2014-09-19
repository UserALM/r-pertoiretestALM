package com.films.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.films.Realisateur;
import com.films.model.Database;
import com.films.view.SpringContext;

/**
 * Servlet implementation class FindRealisator
 */
public class FindRealisator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// récupere l'entity manager de la classe SpringContext
	SpringContext sc = new SpringContext();		   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindRealisator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// On crée une nouvelle instance de Database pour effectuer les opérations sur la base
    	Database db = new Database();
    	
    	// Récupère le nom recherché (champs texte du formulaire
    	String name = request.getParameter("name");
    	
    	//on génère une exception si la servlet trouve le nom elle fais se qui se trouve dans le try
    	try{
    		Realisateur currentRealisator = db.getRealbyName(name);
    		
    		// On stocke le film.toString dans un attribut "titrefilm"   		
    		request.setAttribute("DisplayRealisatorResult", currentRealisator.toString());
    		
      	    request.getRequestDispatcher("/Realisateur/DisplayRealisatorResult.jsp").forward(request, response); 

    	}    	//sinon on affiche une erreur
    	catch(Exception e){
    		PrintWriter out = response.getWriter();
     	   out.println("<a href=\"./DisplayRealisatorForm.jsp\">Impossible rechercher un autre realisateur</a>");
    	}
    	
    	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database db = new Database();
    	
		// On récupère le titre recherché (champs texte du formulaire)
    	String name = request.getParameter("name");
		
		// si le champs texte n'est pas vide
	    if(!name.isEmpty()) {
	    	
			Realisateur currentRealisator = db.getRealbyName(name);
	    	
	    	//System.out.println(currentFilm.getTitre());
	    	
			// On stocke le titre du film dans un attribut "monfilm"
			request.setAttribute("DisplayRealisatorResult", currentRealisator.getNom());
	    	
	    }
	}

}
