package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.Brinquedo;
import br.edu.fatecgru.repository.BrinquedoRepository;

@Service
public class BrinquedoService {

	// Método de puxar todos para realização do teste
	@Autowired
	private BrinquedoRepository brinquedoRepository;

	public List<Brinquedo> listarTodos() {
		return brinquedoRepository.findAll();
	}

	// Listar por contem o nome
	public List<Brinquedo> getByContainsName(String nome) {
		return brinquedoRepository.findByNomeContains(nome);
	}

	// Listar por Id da categoria
	public List<Brinquedo> getByCategoryId(int categoriaId) {
		return brinquedoRepository.findByCategoriaId(categoriaId);
	}
}
