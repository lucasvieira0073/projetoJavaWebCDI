package br.com.projetowebcdi.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor //informa que será um interceptador
public class GerenciadorDeTransacao implements Serializable{
	
	private static final long serialVersionUID = -5385126332383215142L;
	
	@Inject
	EntityManager manager;
	
	//invocationContext é o metodo que foi assinado com @Transacional
	//retorna um Object pois se o metodo anotador retornar algo o executa tx precisa devolver, 
	//pois agora ele seria o metodo completo e o metodo anotado seria apenas um codigo que faz parte desse metodo
	@AroundInvoke //diz para o cdi que este medor ficará ao redor do metodo @Transacional
	public Object executaTx(InvocationContext contexto) throws Exception {
		
		manager.getTransaction().begin();
		
		
		//chamar daos que precisam de transacao
		Object resultado = contexto.proceed();
		
		
		manager.getTransaction().commit();
		
		return resultado;
	}
	
	
}
