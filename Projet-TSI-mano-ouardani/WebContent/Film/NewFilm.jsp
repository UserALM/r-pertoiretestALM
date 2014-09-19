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
<title>Nouveau film</title>
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
%>
<h1> Création d'un film </h1>
<div>
<form action="CreateFilm" method="post">

<p class="saisi">
<label for="titre">Titre:</label>
<input type="text" name="titlefilm" /></p>

<p class="saisi">
<label for="annee">Date de sortie:
<span class="info">(YYYY-MM-DD):</span></label>
<input type="text" name="daterelease" /></p>


<h3> Informations sur le réalisateur </h3>
<p class="saisi">
<label for="prenom">Prénom:</label>
<input type="text" name="r_firstname" /></p>

<p class="saisi">
<label for="nom">Nom:</label>
<input type="text" name="r_lastname" /></p>

<p class="saisi">
<label for="nationalite">Nationnalité:</label>
<input type="text" name="r_nationality" /></p>

<p class="saisi">
<label for="datedenaissance">Date de naissance
<span class="info">(YYYY-MM-DD):</span></label>
<input type="text" name="r_date" /></p>



<h3> Informations sur les acteurs </h3>
<p>Acteur 1: </p>
<p class="saisi">
<label for="prenom">Prénom:</label>
<input type="text" name="a1_firstname" />
</p>
<p class="saisi">
<label for="nom">Nom:</label>
<input type="text" name="a1_lastname" /></p>

<p class="saisi">
<label for="nationalite">Nationnalité:</label>
<input type="text" name="a1_nationality" /></p>

<p class="saisi">
<label for="datedenaissance">Date de naissance
<span class="info">(YYYY-MM-DD):</span></label>
<input type="text" name="a1_date" /></p>


<p>Acteur 2: </p>
<p class="saisi">
<label for="prenom">Prénom:</label>
<input type="text" name="a2_firstname" />
</p>
<p class="saisi">
<label for="nom">Nom:</label>
<input type="text" name="a2_lastname" /></p>

<p class="saisi">
<label for="nationalite">Nationnalité:</label>
<input type="text" name="a2_nationality" /></p>

<p class="saisi">
<label for="datedenaissance">Date de naissance
<span class="info">(YYYY-MM-DD):</span></label>
<input type="text" name="a2_date" /></p>


<p>Acteur 3: </p>
<p class="saisi">
<label for="prenom">Prénom:</label>
<input type="text" name="a3_firstname" />
</p>
<p class="saisi">
<label for="nom">Nom:</label>
<input type="text" name="a3_lastname" /></p>

<p class="saisi">
<label for="nationalite">Nationnalité:</label>
<input type="text" name="a3_nationality" /></p>

<p class="saisi">
<label for="datedenaissance">Date de naissance
<span class="info">(YYYY-MM-DD):</span></label>
<input type="text" name="a3_date" /></p>



<p class="submit">
<input type="submit" value="Ajouter"></input></p>
</form>
</div>
</div>
</div>
</body>
</html>