package com.films.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.films.*;
import com.films.model.Database;

/**
 * Servlet implementation class FindFilm
 */
public class FindFilm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//SpringContext sc = new SpringContext();		   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindFilm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// On crée une nouvelle instance de Database pour effectuer les opérations sur la base
    	Database db = new Database();
  
    	// On récupère le titre recherché (champs texte du formulaire)
		String titre = request.getParameter("titre");
		try{
		// Nouveau film dans lequel on met le résultat
		Film currentFilm = db.getFilmbyTitre(titre);
		
  	    //System.out.println(currentFilm.toString());
		
		// On stocke le film.toString dans un attribut "titrefilm"
  	    request.setAttribute("titrefilm", currentFilm.toString());
  	    
  	    // Envoie le résultat dans DisplayFilmResult.jsp
  	    request.getRequestDispatcher("/Film/DisplayFilmResult.jsp").forward(request, response); 
  	    
	} catch(Exception e){

		PrintWriter out = response.getWriter();
    	   out.println("<a href=\"./DisplayFilmForm.jsp\">Impossible rechercher un autre film</a>"); 
		}
  	    
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On crée une nouvelle instance de Database pour effectuer les opérations sur la base
    	Database db = new Database();
    	
		// On récupère le titre recherché (champs texte du formulaire)
		String titre = request.getParameter("titre");
		
		// si le champs texte n'est pas vide
	    if(!titre.isEmpty()) {
	    	
			Film currentFilm = db.getFilmbyTitre(titre);
	    	
	    	//System.out.println(currentFilm.getTitre());
	    	
			// On stocke le titre du film dans un attribut "DisplayFilmForm"
			request.setAttribute("DisplayFilmForm", currentFilm.getTitre());

	  	    // Envoie le résultat dans DisplayFilmForm.jsp
	    	//request.getRequestDispatcher("/DisplayFilmForm.jsp").forward(request, response);
	    	
	    }
	}
}
