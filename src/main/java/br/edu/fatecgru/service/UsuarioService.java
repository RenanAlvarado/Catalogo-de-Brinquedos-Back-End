package br.edu.fatecgru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.TipoUsuario;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.repository.UsuarioRepository;

@Service
public class UsuarioService {

	// Método para puxar todos para a realização de teste
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	// Listar pelo ID do brinquedo
	public Usuario getById(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	// Login
	public Usuario login(String email, String senha) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

		if (usuarioOpt.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado");
		}

		// Carregar objeto usuário
		Usuario usuario = usuarioOpt.get();

		if (!usuario.getSenha().equals(senha)) {
			throw new RuntimeException("Senha inválida");
		}

		return usuario;
	}

	// Cadastro
	public Usuario cadastrar(String nome, String email, String senha) {

		// Se email já existe
		if (usuarioRepository.findByEmail(email).isPresent()) {
			throw new RuntimeException("Email já cadastrado");
		}

		Usuario usuario = new Usuario();

		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTipo(TipoUsuario.CLIENTE);
		usuario.setTelefone(null);
		usuario.setEndereco(null);

		return usuarioRepository.save(usuario);
	}

}
