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
}
