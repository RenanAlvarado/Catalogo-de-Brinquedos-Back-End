package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	// Listar pelo ID do brinquedo
	public Brinquedo getById(int id) {
		return brinquedoRepository.findById(id).orElse(null);
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

	// Filtros unificados
	public Page<Brinquedo> filtrar(List<Long> categorias, List<Long> marcas, int page, int size, String sort) {

		Sort ordenacao = Sort.unsorted();

		if (sort != null && sort.contains(",")) {
			String[] partes = sort.split(",");

			String campo = partes[0];
			String direcao = partes[1];

			if (direcao.equalsIgnoreCase("asc")) {
				ordenacao = Sort.by(campo).ascending();
			} else {
				ordenacao = Sort.by(campo).descending();
			}
		}

		Pageable pageable = PageRequest.of(page, size, ordenacao);

		return brinquedoRepository.filtrar(categorias, marcas, pageable);
	}

	// Método para salvar ou alterar brinquedo
	public Brinquedo saveBrinquedo(Brinquedo brinquedo) {
		return brinquedoRepository.save(brinquedo);
	}

	// Método para excluir brinquedo
	public void deleteBrinquedo(int id) {
		brinquedoRepository.deleteById(id);
	}

}
