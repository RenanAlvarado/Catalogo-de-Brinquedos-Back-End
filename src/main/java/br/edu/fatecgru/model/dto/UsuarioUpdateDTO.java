package br.edu.fatecgru.model.dto;

import br.edu.fatecgru.model.entity.Endereco;

public class UsuarioUpdateDTO {

	// Atributos que podem ser atualizados
	private String nome;

	private String telefone;

	private Endereco endereco;

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
