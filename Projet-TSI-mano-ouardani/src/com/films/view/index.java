package com.films.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;


import com.films.*;
import com.films.model.Database;
import com.films.view.SpringContext;

/**
 * Servlet implementation class index
 */
public class index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	  SpringContext sc = new SpringContext();		   
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*Database db = new Database();
		/*EntityTransaction tx = sc.getEm().getTransaction();
		tx.begin();
		
		//create();
	
		db.listActeurs();
		db.listRealisateurs();
		db.listFilms();
		tx.commit();
		    @SuppressWarnings({ "rawtypes", "unused" })
			ArrayList listFilms = (ArrayList) db.listFilms();
		   
		    
	      String Acteur = request.getParameter("Acteur");
	      
	      PrintWriter out = response.getWriter();
		   out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
		     + "Transitional//EN\">\n"
		     + "<HTML>\n"
		     + "<HEAD><TITLE>Hello</TITLE></HEAD>\n"
		     + "<BODY>\n");
		 //  db.getActeurbyName("willou");
		   out.println(Acteur);
		   for (Film f : db.listFilms()){
	              //System.out.println(f.toString()+"<br>");
		   //out.println(f.toString());
		   }
//		   out.println(sc);
		   out.println("</BODY></HTML>");
		 
	      
		 String titre = request.getParameter("titre");

		   Film currentFilm = new Film();
  	   currentFilm.setTitre(titre);
  	   currentFilm = db.getFilmbyTitre(titre);
  	   PrintWriter out = response.getWriter();
  	   out.println(currentFilm.toString());
  	   request.setAttribute("titrefilm", currentFilm.toString());
  	   //request.setAttribute("anneefilm", currentFilm.getAnnee());
  	   request.getRequestDispatcher("/monfilm.jsp").forward(request, response);
	*/	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			/*
	       String titre = request.getParameter("titre");
	       Database db = new Database();
	       
	       if(!titre.isEmpty()){
	    	   Film currentFilm = new Film();
	    	   currentFilm.setTitre(titre);
	    	   currentFilm = db.getFilmbyTitre(titre);
	    	   @SuppressWarnings("unused")
			PrintWriter out = response.getWriter();
	    	   System.out.println(currentFilm.getTitre());
	    	   request.setAttribute("monfilm", currentFilm.getTitre());
	    	   request.getRequestDispatcher("/monfilm.jsp").forward(request, response);
	    	   }
    */
		}
			
	}

			
		

}
