package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.fatecgru.model.entity.Brinquedo;
import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.service.CategoriaService;
import br.edu.fatecgru.service.ImagemService;

@CrossOrigin(origins = "*")
@RestController
//Cria o geral, todos precisam desse
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ImagemService imagemService;

	@GetMapping
	public List<Categoria> listarTodos() {
		return categoriaService.listarTodos();
	}

	@GetMapping("/{id}")
	public Categoria buscarPorId(@PathVariable int id) {
		return categoriaService.getById(id);
	}

	// Busca de categoria pelo nome
	@GetMapping("/contem-nome/{nome}")
	public List<Categoria> buscarPorContemNome(@PathVariable String nome) {
		return categoriaService.getByContainsName(nome);
	}

	// Pasta das categorias para salvar
	String pastaCategorias = "categories/";

	// Salvar categoria
	@PostMapping
	public ResponseEntity<?> insert(@RequestPart("categoria") String categoriaJson,
			@RequestPart(value = "imagem", required = false) MultipartFile imagem) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Categoria categoria = mapper.readValue(categoriaJson, Categoria.class);

			String nomeImagem = imagemService.salvarImagem(imagem, pastaCategorias);

			if (nomeImagem != null) {
				categoria.setImagem(nomeImagem);
			}

			return ResponseEntity.ok(categoriaService.saveCategoria(categoria));

		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	// Alterar categoria
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestPart("categoria") String categoriaJson,
			@RequestPart(value = "imagem", required = false) MultipartFile imagem) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Brinquedo novo = mapper.readValue(categoriaJson, Brinquedo.class);

			Categoria atual = categoriaService.getById(id);

			atual.setNome(novo.getNome());

			String imagemAtualizada = imagemService.substituirImagem(atual.getImagem(), imagem, pastaCategorias);

			atual.setImagem(imagemAtualizada);

			return ResponseEntity.ok(categoriaService.saveCategoria(atual));

		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	// Deletar categoria
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		try {
			Categoria categoria = categoriaService.getById(id);

			if (categoria.getImagem() != null) {
				imagemService.deletarImagem(categoria.getImagem(), pastaCategorias);
			}

			categoriaService.deleteCategoria(id);

			return ResponseEntity.noContent().build(); // 204

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro ao deletar: " + e.getMessage());
		}
	}

}
