package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	// Listar por Id da marca
	public List<Brinquedo> getByBrandId(int marcaId) {
		return brinquedoRepository.findByMarcaId(marcaId);
	}

	// Listar paginado
	public Page<Brinquedo> listarPaginado(int page, int size) {
		return brinquedoRepository.findAll(PageRequest.of(page, size));
	}

}
