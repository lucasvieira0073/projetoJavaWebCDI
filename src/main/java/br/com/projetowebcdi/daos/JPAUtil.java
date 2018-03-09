package br.com.projetowebcdi.daos;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable{
	
	private static final long serialVersionUID = -38751114397479244L;
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("webcdiPU");

	//o cdi sabe que é esse método que sera usado para construir o entitymanager pois retorna o tipo entitymanager
	@Produces
	@RequestScoped // quantas vezes o cdi irá criar o entity manager (neste caso a cada requisição)
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	
	public void close(@Disposes EntityManager em) { //quando terminar a requisição ele executa esse metodo
		//public void close(EntityManager em) { 
		em.close();
	}
	
}
