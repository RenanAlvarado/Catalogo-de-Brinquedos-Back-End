package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/{id}")
	public Brinquedo buscarPorId(@PathVariable int id) {
		return brinquedoService.getById(id);
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

	// Listar os brinquedos por página
	@GetMapping("/listar-paginas")
	public Page<Brinquedo> listar(@RequestParam(defaultValue = "0") int page,

			@RequestParam(defaultValue = "16") int size) {

		return brinquedoService.listarPaginado(page, size);
	}

	@GetMapping("/filtrar")
	public Page<Brinquedo> filtrar(@RequestParam(required = false) List<Long> categorias,
			@RequestParam(required = false) List<Long> marcas, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "15") int size, @RequestParam(required = false) String sort) {
		return brinquedoService.filtrar(categorias, marcas, page, size, sort);
	}

	// Salvar brinquedo
	@PostMapping
	public Brinquedo insert(@RequestBody Brinquedo brinquedo) {
		return brinquedoService.saveBrinquedo(brinquedo);
	}

	// Alterar brinquedo
	@PutMapping("/{id}")
	public Brinquedo update(@RequestBody Brinquedo brinquedo, @PathVariable Integer id) {
		Brinquedo brinquedoUpdate = brinquedoService.getById(id);
		brinquedoUpdate.setNome(brinquedo.getNome());
		brinquedoUpdate.setDescricao(brinquedo.getDescricao());
		brinquedoUpdate.setImagem(brinquedo.getImagem());
		brinquedoUpdate.setPreco(brinquedo.getPreco());
		brinquedoUpdate.setCategoria(brinquedo.getCategoria());
		brinquedoUpdate.setMarca(brinquedo.getMarca());
		return brinquedoService.saveBrinquedo(brinquedoUpdate);
	}

	// Deletar brinquedo
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		brinquedoService.deleteBrinquedo(id);
		return "Brinquedo Excluido com sucesso!";
	}

}
