package br.com.projetowebcdi.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetowebcdi.daos.ProdutoDao;
import br.com.projetowebcdi.models.Produto;
import br.com.projetowebcdi.tx.Transacional;

/**
 * usados sem cdi
 * @ManagedBean
 * @RequestScoped
 *
 */

@Named
@RequestScoped//enterprise context RequestScoped
public class ProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 6543839311388129620L;

	private List<Produto> produtos = new ArrayList<>();

	private Produto produto = new Produto();

	@Inject
	private ProdutoDao produtoDao;;

	public ProdutoBean() {

		System.out.println("Nova instancia");
	}

	@Transacional
	public String salvar() {
		System.out.println("REALIZANDO A FUNCAO DE SALVAR");

		if (produto.getId() == null) {
			this.produtoDao.persist(produto);

			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Produto cadastrado com sucesso!"));
		}
		return "home?faces-redirect=true";
	}
	
	public List<Produto> listar() {
		return this.produtoDao.findAll();
	}
	
	public int contarProdutos() {
		return this.produtoDao.count();
	}

	public Produto pesquisarProduto(Integer id) {
		return this.produtoDao.finById(id);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
