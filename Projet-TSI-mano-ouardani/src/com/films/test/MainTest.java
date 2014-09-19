package com.films.test;

import java.util.Date;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import com.films.*;
import com.films.view.SpringContext;

public class MainTest {

	/**
	 * @param args
	 */
	/*static EntityManager entityManager;
	
	@Before
	public void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory)context.getBean("entityManagerFactory");
		entityManager = entityManagerFactory.createEntityManager();
	}*/
	
	SpringContext sc = new SpringContext();
	
	@SuppressWarnings({ "deprecation", "static-access" })
	@Test
	public void create() {
		Date date =  new Date();
		// Création de réalisateurs test
		
		// Modifie la valeur de la date
		date.setYear(1972-1900);	date.setMonth(7);	date.setDate(15);
		Realisateur realisateur1 = new Realisateur("Affleck", "Benjamin", "Americain", date);
		
		date.setYear(1965-1900);	date.setMonth(7);	date.setDate(1);
		Realisateur realisateur2 = new Realisateur("Mendes", "Sam", "Britannique", date);
		
		sc.getEm().persist(realisateur1);
		sc.getEm().persist(realisateur2);
		
		// Création d'acteurs test
	
		date.setYear(1972-1900);	date.setMonth(7);	date.setDate(15);
		Acteur acteur1 = new Acteur("Affleck", "Benjamin", "Americain", date);
		
		date.setYear(1956-1900);	date.setMonth(2);	date.setDate(7);
		Acteur acteur2 = new Acteur("Cranston", "Bryan", "Americain", date);
		
		date.setYear(1952-1900);	date.setMonth(5);	date.setDate(20);
		Acteur acteur3 = new Acteur("Goodman", "John", "Americain", date);
		
		date.setYear(1968-1900);	date.setMonth(2);	date.setDate(2);
		Acteur acteur4 = new Acteur("Craig", "Daniel", "Britannique", date);
		
		date.setYear(1969-1900);	date.setMonth(2);	date.setDate(1);
		Acteur acteur5 = new Acteur("Bardem", "Javier", "Espagnol", date);
		
		date.setYear(1934-1900);	date.setMonth(12);	date.setDate(9);
		Acteur acteur6 = new Acteur("Dench", "Judi", "Britannique", date);
		
		date.setYear(1982-1900);	date.setMonth(4);	date.setDate(19);
		Acteur acteur7 = new Acteur("Hall", "Rebecca", "Britannique", date);
		
		date.setYear(1971-1900);	date.setMonth(2);	date.setDate(10);
		Acteur acteur8 = new Acteur("Hamm", "Jon", "Americain", date);
		
		sc.getEm().persist(acteur1);
		sc.getEm().persist(acteur2);
		sc.getEm().persist(acteur3);
		sc.getEm().persist(acteur4);
		sc.getEm().persist(acteur5);
		sc.getEm().persist(acteur6);
		sc.getEm().persist(acteur7);
		sc.getEm().persist(acteur8);

		// Création de films test
		
		date.setYear(2012-1900);	date.setMonth(9);	date.setDate(26);
		Film film1 = new Film("Skyfall",date, realisateur2, acteur4, acteur6, acteur5);
		
		date.setYear(2012-1900);	date.setMonth(10);	date.setDate(7);
		Film film2 = new Film("Argo", date, realisateur1, acteur1, acteur2, acteur3);
		
		date.setYear(2010-1900);	date.setMonth(8);	date.setDate(15);
		Film film3 = new Film("Le Hobbit", date, realisateur1, acteur1, acteur7, acteur8);
		
		sc.getEm().persist(film1);
		sc.getEm().persist(film2);
		sc.getEm().persist(film3);

	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void test() {

		//Database db = new Database();
		EntityTransaction tx = sc.getEm().getTransaction();
		tx.begin();
		//create();
		/*db.listActeurs();
		db.listRealisateurs();
		db.getActeurbyName("willou");
		db.getRealbyName("bibi");
		db.listFilms();
		db.getFilmbyTitre("Argo");*/
		tx.commit();
	}

}
