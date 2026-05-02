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

import br.edu.fatecgru.model.entity.Marca;
import br.edu.fatecgru.service.ImagemService;
import br.edu.fatecgru.service.MarcaService;

@CrossOrigin(origins = "*")
@RestController
//Cria o geral, todos precisam desse
@RequestMapping("/api/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@Autowired
	private ImagemService imagemService;

	@GetMapping
	public List<Marca> listarTodos() {
		return marcaService.listarTodos();
	}

	@GetMapping("/{id}")
	public Marca buscarPorId(@PathVariable int id) {
		return marcaService.getById(id);
	}

	// Busca por contem nome
	@GetMapping("/contem-nome/{nome}")
	public List<Marca> buscarPorContemNome(@PathVariable String nome) {
		return marcaService.getByContainsName(nome);
	}

	// Pasta das marcas para salvar
	String pastaMarcas = "brands/";

	// Salvar marca
	@PostMapping
	public ResponseEntity<?> insert(@RequestPart("marca") String marcaJson,
			@RequestPart(value = "imagem", required = false) MultipartFile imagem) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Marca marca = mapper.readValue(marcaJson, Marca.class);

			String nomeImagem = imagemService.salvarImagem(imagem);

			if (nomeImagem != null) {
				marca.setImagem(nomeImagem);
			}

			return ResponseEntity.ok(marcaService.saveMarca(marca));

		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	// Alterar marca
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestPart("marca") String marcaJson,
			@RequestPart(value = "imagem", required = false) MultipartFile imagem) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Marca novo = mapper.readValue(marcaJson, Marca.class);

			Marca atual = marcaService.getById(id);

			atual.setNome(novo.getNome());

			String imagemAtualizada = imagemService.substituirImagem(atual.getImagem(), imagem);

			atual.setImagem(imagemAtualizada);

			return ResponseEntity.ok(marcaService.saveMarca(atual));

		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	// Deletar marca
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		try {
			Marca marca = marcaService.getById(id);

			if (marca.getImagem() != null) {
				imagemService.deletarImagem(marca.getImagem());
			}

			marcaService.deleteMarca(id);

			return ResponseEntity.noContent().build(); // 204

		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}
