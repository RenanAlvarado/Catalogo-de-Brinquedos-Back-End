package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	// Método para puxar todos para a realização de teste
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listarTodos(){
		return usuarioRepository.findAll();
	}
	
	
}
