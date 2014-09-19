package com.films.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
	static ApplicationContext context;
	static EntityManager em;
	
	static{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EntityManagerFactory emf = (EntityManagerFactory)context.getBean("entityManagerFactory");
		em = emf.createEntityManager();	
		
	}
	
	/*public SpringContext(){
		
		}
	*/
	@Before
	public static EntityManager getEm() {
		return em;
	}

	public static void setEm(EntityManager em) {
		SpringContext.em = em;
	}
	public static ApplicationContext getApplicationContext(){
		return context;
		
	}
	
}
