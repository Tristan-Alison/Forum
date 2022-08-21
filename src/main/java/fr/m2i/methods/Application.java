package fr.m2i.methods;


import java.util.ArrayList;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import fr.m2i.models.Comment;
import fr.m2i.models.News;
import fr.m2i.models.UserLogin;


public class Application {
	
	@Resource(name="dataSource")
	private DataSource dataSource;
	
	//LOGIN
	public static UserLogin login(String username, String psw) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();
		UserLogin user = null;
		try{
		user = (UserLogin) em.createNativeQuery("SELECT * from user WHERE username=?", UserLogin.class)
				.setParameter(1,username)
				.getSingleResult();
		System.out.println(user);
		}catch (NoResultException e){
			System.out.println("Pas de compte trouvé");
		}

		
		if (user!= null) {
			if (user.getPsw().equals(psw)) return null;
			System.out.println(user.getNom());
		}
		System.out.println("USER: "+user);
		em.close();
		
		return user;
	}

	
	
	public static ArrayList<News> display() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();

		@SuppressWarnings("unchecked")
		ArrayList<News> listeTaches = (ArrayList<News>) em.createNativeQuery("SELECT * from news", News.class)
				.getResultList();

		em.close();
		System.out.println(listeTaches);
		return listeTaches;
	}
	public static ArrayList<News> displayFive() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();

		@SuppressWarnings("unchecked")
		ArrayList<News> listeTaches = (ArrayList<News>) em.createNativeQuery("SELECT * from news  Order by 1 DESC LIMIT 5", News.class)
				.getResultList();

		em.close();
		System.out.println(listeTaches);
		return listeTaches;
	}
	
	//ADD
	public static void add(News news){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();

		boolean transac = false;
		try {
			em.getTransaction().begin();
			em.persist(news);
			transac = true;
		}
		finally {
			if (transac) {
				em.getTransaction().commit();
			}
			else {
				em.getTransaction().rollback();
			}	
		}			
		em.close();
	}
	
	//DELETE
	public static void delete(Integer id){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();

		News news = em.find(News.class,id);
		
		boolean transac = false;
		try {
			em.getTransaction().begin();
			em.remove(news);
			transac=true;
		}finally {
			if (transac) {
				em.getTransaction().commit();
			}
			else {
				em.getTransaction().rollback();
			}	
		}			
		em.close();
	}
	
	//MODIFY
	public static void modify(Integer id, News news){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();

		News newsU = em.find(News.class,id);
		boolean transac = false;
		try {
			em.getTransaction().begin();
				newsU.setTitle(news.getTitle());
				newsU.setTexte(news.getTexte());
				transac=true;
		}finally {
			if (transac) {
				em.getTransaction().commit();
			}
			else {
				em.getTransaction().rollback();
			}	
		}		
			
		em.close();
	}
	
	//MODIFY
public static void addComment(Comment comment){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();

		boolean transac = false;
		try {
			em.getTransaction().begin();
			em.persist(comment);
			transac = true;
		}
		finally {
			if (transac) {
				em.getTransaction().commit();
			}
			else {
				em.getTransaction().rollback();
			}	
		}			
		em.close();
	}
	
	
//DELETE
	public static void deleteComment(Integer id){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();

		Comment comment = em.find(Comment.class,id);
		
		boolean transac = false;
		try {
			em.getTransaction().begin();
			em.remove(comment);
			transac=true;
		}finally {
			if (transac) {
				em.getTransaction().commit();
			}
			else {
				em.getTransaction().rollback();
			}	
		}			
		em.close();
	}
	
	
	
	
	
	
	public static void updateComment(Integer id, Comment comment){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();

		Comment commentN = em.find(Comment.class,id);
		
		boolean transac = false;
		try {
			em.getTransaction().begin();
			commentN.setMessage(comment.getMessage());

				transac=true;
		}finally {
			if (transac) {
				em.getTransaction().commit();
			}
			else {
				em.getTransaction().rollback();
			}	
		}		
			
		em.close();
	}
	


}