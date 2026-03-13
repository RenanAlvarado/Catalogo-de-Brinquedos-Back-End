package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "brinquedos")
public class Brinquedo {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome, descricao, imagem;

	private double preco;

	// Uma categoria para muitos brinquedos
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	// Uma marca para muitos brinquedos
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

	// Construtores
	public Brinquedo() {

	}

	public Brinquedo(Integer id, String nome, String descricao, String imagem, double preco, Categoria categoria,
			Marca marca) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.preco = preco;
		this.categoria = categoria;
		this.marca = marca;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
