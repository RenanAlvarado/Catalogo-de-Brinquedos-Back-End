package br.edu.fatecgru.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public class UsuarioUpdateDTO {

	// Atributos que podem ser atualizados, junto com as validações

	// Nome obrigatório e completo
	@Pattern(regexp = "^[A-Za-zÀ-ÿ]+\\s+[A-Za-zÀ-ÿ\\s]+$", message = "Digite o nome completo")
	private String nome;

	// Telefone opcional, mas válido se preenchido
	@Pattern(regexp = "^$|^\\d{10,11}$", message = "Telefone inválido")
	private String telefone;

	// Endereço validado também
	@Valid
	private EnderecoDTO endereco;

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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

}
