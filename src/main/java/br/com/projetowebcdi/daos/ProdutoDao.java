package br.com.projetowebcdi.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.projetowebcdi.models.Produto;



public class ProdutoDao {
	
	@Inject
	EntityManager manager;
	
	public void persist(Produto produto) {

		this.manager.persist(produto);

	}

	public void remove(Produto produto) {

		this.manager.remove(this.manager.merge(produto));

	}

	public void merge(Produto produto) {

		this.manager.merge(produto);

	}

	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		
		List<Produto> produtos = this.manager.createQuery("select p from Produto p").getResultList();

		return produtos;
	}

	public Produto finById(Integer id) {
		
		Produto produto = this.manager.find(Produto.class, id);

		return produto;
	}

	public int count() {
		
		long result = (Long) this.manager.createQuery("select count(p) from Produto p").getSingleResult();

		return (int) result;
	}
	
}
