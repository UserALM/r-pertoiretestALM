<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
      import="com.films.model.Database"
      import="java.util.*"
      import="com.films.*"
      import="com.films.view.SpringContext"
      %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listefilm</title>
<link rel="stylesheet" type="text/css" href="../style.css" />
</head>
<body>
<!-- debut design -->
<div id="header">

<a href="http://localhost:8080/venteEnLigne/"><img src="../templates/images/sky_logo.png" alt="Une photo"/></a>
<h1>Projet TSI MANO-OUARDANI</h1>


</div>
<div id="main">
<div id="menu">	
<ul>
<li><a  href="../Film/DisplayFilmForm.jsp">Rechercher un film</a></li>
<li><a  href="../Acteur/DisplayActorForm.jsp">Rechercher un acteur</a></li>
<li><a  href="../Realisateur/DisplayRealisatorForm.jsp">Rechercher un réalisateur</a></li>
<li><a  href="../Film/NewFilm.jsp">Créer un film</a></li>
<li><a  href="../Acteur/NewActor.jsp">Créer un acteur</a></li>
<li><a  href="../Realisateur/NewRealisator.jsp">Créer un réalisateur</a></li>
</ul>
</div>
	
<div id="centre"> 
<!-- fin debut design -->
<%
	SpringContext sc = new SpringContext();
	Database db = new Database();
	List<Film> listFilm = (List<Film>) db.listFilms();
%>
<h1> FILMS </h1>
<h2>Afficher un film:</h2> 
<div><% 
			// simplement, on récupere la liste des users!!!
            for (int i = 0; i < listFilm.size(); i++) {
            out.println("<div><a href=\"FindFilm?titre=" +listFilm.get(i).getTitre()+ "\">" +listFilm.get(i).getTitre()+ "</a></div>" );     	
            }
%> </div>
<br></br>
<div>
<form action ="FindFilm" methode="post">
<h2>Rechercher un film :</h2>
<input type="text" name="titre" />
<input type="submit" value="recherche"></input>
</form>
</div>
</div>
</div>
</body>
</html>