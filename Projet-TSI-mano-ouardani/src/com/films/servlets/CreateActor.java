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
import com.films.view.SpringContext;

/**
 * Servlet implementation class CreateActor
 */
public class CreateActor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SpringContext sc = new SpringContext();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateActor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*Database db = new Database();
		
    	EntityTransaction tx = sc.getEm().getTransaction();
		tx.begin();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			// On récupère champs texte du formulaire)
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String nationality = request.getParameter("nationality");
			Date date = formatter.parse(request.getParameter("date"));
			// si les champs texte n'est pas vide
		    if(!firstname.isEmpty() && !lastname.isEmpty() && !nationality.isEmpty() && date!=null) {	
	    	Acteur currentActor = new Acteur(lastname, firstname, nationality, date);	
	    	System.out.println(currentActor);
	    	
			//Acteur testActor =  db.getActeurbyName(lastname);
	    	//System.out.println(testActor);
		
			//if(currentActor.getNom() != testActor.getNom() && currentActor.getPrenom()!= testActor.getPrenom() ){
	    	//sc.getEm().persist(currentActor);
	    //request.getRequestDispatcher("/myActor.jsp").forward(request, response);
			//tx.commit();
		   /* }else{
		    	//ne pas oublier page d'erreur
		    	PrintWriter out = response.getWriter();
				out.println("<a href=\"./DisplayActor.jsp\">Cette acteur existe déja!!!</a>");

		    }
	    	//verifActor(firstname,lastname,date, nationality, db);
		  }
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

    	
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
		    	boolean exist = db.createActor(firstname, lastname, nationality, date);
	    	
				if (!exist) {	
					// Afficher la confirmation de création
					request.getRequestDispatcher("/Acteur/NewActorConfirm.jsp").forward(request, response);
				}
				else {
			    	// Affiche un message d'erreur s'il existe déjà avec un lien vers la page de création
					out.println("<a href=\"./NewActor.jsp\">Cet acteur existe déja!!!</a>");
			    }
	    	}
		    else {
		    	// Affiche un message d'erreur si certains champs sont vides avec un lien vers la page de création
		    	out.println("<a href=\"./NewActor.jsp\">Veuillez remplir tous les champs</a>");
		    }
		} catch (ParseException e) {
			// Affiche un message d'erreur si certains champs sont vides avec un lien vers la page de création
	    	out.println("<a href=\"./NewActor.jsp\">Veuillez remplir tous les champs</a>");
		}
	}
}
