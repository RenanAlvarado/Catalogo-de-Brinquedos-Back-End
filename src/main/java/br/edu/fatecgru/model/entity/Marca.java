package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public String nome, imagem;

	// Construtores
	public Marca() {

	}

<<<<<<< HEAD
	public Marca(String nome, String imagem) {
=======
	public Marca(Integer id, String nome, String imagem) {

		this.id = id;
>>>>>>> branch 'master' of https://github.com/RenanAlvarado/Catalogo-de-Brinquedos-Back-End.git
		this.nome = nome;
		this.imagem = imagem;
	}

	// Getters e Setters
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

}
