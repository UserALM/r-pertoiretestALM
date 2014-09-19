<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<title>Votre Realisateur</title><link rel="stylesheet" type="text/css" href="../style.css" />
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
<h1>Votre Realisateur :</h1>
<%

      String myname = (String) request.getAttribute("DisplayRealisatorResult");
		out.println(myname.toString());
%><br></br>
<a href="./DisplayRealisatorForm.jsp">retour</a>

</div>
</div>
</body>
</html>