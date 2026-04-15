package br.edu.fatecgru.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome, imagem;

	@OneToMany(mappedBy = "marca", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonIgnore
	private List<Brinquedo> brinquedos;

	// Construtores
	public Marca() {

	}

	public Marca(Integer id, String nome, String imagem) {
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
	}

	// Getters e Setters
	public Integer getId() {
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<Brinquedo> getBrinquedos() {
		return brinquedos;
	}

}
