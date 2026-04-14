package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.repository.CategoriaRepository;

@Service
public class CategoriaService {

	// Método de puxar todos para realização do teste
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}

	// Consulta por categoria que contém no nome
	public List<Categoria> getByContainsName(String nome) {
		return categoriaRepository.findByNomeContains(nome);
	}

	// Consulta por id categoria
	public Categoria getById(int id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	// Método para salvar ou alterar categoria
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	// Método para excluir categoria
	public void deleteCategoria(int id) {
		categoriaRepository.deleteById(id);
	}

}
