package br.com.projetowebcdi.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.projetowebcdi.models.Produto;

public class ProdutoDao {
	public void persist(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		manager.persist(produto);

		manager.getTransaction().commit();

		manager.close();
	}

	public void remove(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		manager.remove(manager.merge(produto));

		manager.getTransaction().commit();

		manager.close();
	}

	public void merge(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		manager.merge(produto);

		manager.getTransaction().commit();

		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {

		EntityManager manager = new JPAUtil().getEntityManager();

		List<Produto> produtos = manager.createQuery("select p from Produto p").getResultList();

		manager.close();
		return produtos;
	}

	public Produto finById(Integer id) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Produto produto = manager.find(Produto.class, id);
		manager.close();
		return produto;
	}

	public int count() {
		EntityManager manager = new JPAUtil().getEntityManager();
		long result = (Long) manager.createQuery("select count(p) from Produto p").getSingleResult();
		manager.close();

		return (int) result;
	}
}
