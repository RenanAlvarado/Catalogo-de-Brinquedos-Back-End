package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.model.entity.Brinquedo;
import br.edu.fatecgru.service.BrinquedoService;

@CrossOrigin(origins = "*")
@RestController
//Cria o geral, todos precisam desse
@RequestMapping("/api/brinquedos")
public class BrinquedoController {

	@Autowired
	private BrinquedoService brinquedoService;

	@GetMapping
	public List<Brinquedo> listarTodos() {
		return brinquedoService.listarTodos();
	}

	// Busca por contem nome
	@GetMapping("/contem-nome/{nome}")
	public List<Brinquedo> buscarPorContemNome(@PathVariable String nome) {
		return brinquedoService.getByContainsName(nome);
	}

	// Busca por Id da categoria
	@GetMapping("/categoria/{id}")
	public List<Brinquedo> buscarPorIdCategoria(@PathVariable int id) {
		return brinquedoService.getByCategoryId(id);
	}

	// Busca por Id da marca
	@GetMapping("/marca/{id}")
	public List<Brinquedo> buscarPorIdMarca(@PathVariable int id) {
		return brinquedoService.getByBrandId(id);
	}

}
