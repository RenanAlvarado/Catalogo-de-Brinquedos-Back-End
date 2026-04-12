package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.fatecgru.model.entity.Brinquedo;
import br.edu.fatecgru.service.BrinquedoService;
import br.edu.fatecgru.service.ImagemService;

@CrossOrigin(origins = "*")
@RestController
//Cria o geral, todos precisam desse
@RequestMapping("/api/brinquedos")
public class BrinquedoController {

	@Autowired
	private BrinquedoService brinquedoService;

	@Autowired
	private ImagemService imagemService;

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
	public ResponseEntity<?> insert(@RequestPart("brinquedo") String brinquedoJson,
			@RequestPart(value = "imagem", required = false) MultipartFile imagem) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Brinquedo brinquedo = mapper.readValue(brinquedoJson, Brinquedo.class);

			String nomeImagem = imagemService.salvarImagem(imagem);

			if (nomeImagem != null) {
				brinquedo.setImagem(nomeImagem);
			}

			return ResponseEntity.ok(brinquedoService.saveBrinquedo(brinquedo));

		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	// Alterar brinquedo
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestPart("brinquedo") String brinquedoJson,
			@RequestPart(value = "imagem", required = false) MultipartFile imagem) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Brinquedo novo = mapper.readValue(brinquedoJson, Brinquedo.class);

			Brinquedo atual = brinquedoService.getById(id);

			atual.setNome(novo.getNome());
			atual.setDescricao(novo.getDescricao());
			atual.setPreco(novo.getPreco());
			atual.setCategoria(novo.getCategoria());
			atual.setMarca(novo.getMarca());

			String imagemAtualizada = imagemService.substituirImagem(atual.getImagem(), imagem);

			atual.setImagem(imagemAtualizada);

			return ResponseEntity.ok(brinquedoService.saveBrinquedo(atual));

		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	// Deletar brinquedo
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		try {
			Brinquedo brinquedo = brinquedoService.getById(id);

			if (brinquedo.getImagem() != null) {
				imagemService.deletarImagem(brinquedo.getImagem());
			}

			brinquedoService.deleteBrinquedo(id);

			return ResponseEntity.noContent().build(); // 204

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro ao deletar: " + e.getMessage());
		}
	}
}
