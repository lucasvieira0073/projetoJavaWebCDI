package br.com.projetowebcdi.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.projetowebcdi.daos.ProdutoDao;
import br.com.projetowebcdi.models.Produto;

@ManagedBean
@RequestScoped
public class ProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 6543839311388129620L;

	private List<Produto> produtos = new ArrayList<>();

	private Produto produto = new Produto();

	private ProdutoDao produtoDao = new ProdutoDao();

	public ProdutoBean() {

		System.out.println("Nova instancia");
	}

	public String salvar() {
		System.out.println("REALIZANDO A FUN��O DE SALVAR");

		if (produto.getId() == null) {
			produtoDao.persist(produto);

			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Produto cadastrado com sucesso!"));
		}
		return "home?faces-redirect=true";
	}
	
	public List<Produto> listar() {
		return produtoDao.findAll();
	}
	
	public int contarProdutos() {
		return produtoDao.count();
	}

	public Produto pesquisarProduto(Integer id) {
		return produtoDao.finById(id);
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
