package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca {

	// Atributos
	public String nome, imagem;

	// Construtores
	public Marca() {

	}

	public Marca(String nome, String imagem) {
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
