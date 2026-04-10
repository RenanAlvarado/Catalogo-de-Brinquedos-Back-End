package br.edu.fatecgru.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	public ResponseEntity<?> insert(@RequestPart("brinquedo") String brinquedoJson,
			@RequestPart(value = "imagem", required = false) MultipartFile imagem) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Brinquedo brinquedo = mapper.readValue(brinquedoJson, Brinquedo.class);

			// Mostra no log o JSON recebido
			System.out.println("JSON recebido: " + brinquedoJson);

			if (imagem != null && !imagem.isEmpty()) {
				// Pasta de upload
				String pasta = System.getProperty("user.dir") + "/uploads/toys/";
				File diretorio = new File(pasta);
				if (!diretorio.exists()) {
					diretorio.mkdirs();
				}

				String nomeArquivo = System.currentTimeMillis() + "_" + imagem.getOriginalFilename();
				Path caminho = Paths.get(pasta + nomeArquivo);
				Files.write(caminho, imagem.getBytes());

				System.out.println("Imagem salva em: " + caminho.toAbsolutePath());
				brinquedo.setImagem(nomeArquivo);
			}

			Brinquedo salvo = brinquedoService.saveBrinquedo(brinquedo);
			System.out.println("Brinquedo salvo: " + salvo.getId());
			return ResponseEntity.ok(salvo);

		} catch (Exception e) {
			e.printStackTrace(); // Mostra exatamente o que deu errado no backend
			return ResponseEntity.status(500).body("Erro interno: " + e.toString());
		}
	}

	// Alterar brinquedo
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestPart("brinquedo") String brinquedoJson,
			@RequestPart(value = "imagem", required = false) MultipartFile imagem) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Brinquedo brinquedoNovo = mapper.readValue(brinquedoJson, Brinquedo.class);

			// log do JSON recebido
			System.out.println("JSON recebido (UPDATE): " + brinquedoJson);

			// busca o existente no banco
			Brinquedo brinquedo = brinquedoService.getById(id);

			// atualiza os campos
			brinquedo.setNome(brinquedoNovo.getNome());
			brinquedo.setDescricao(brinquedoNovo.getDescricao());
			brinquedo.setPreco(brinquedoNovo.getPreco());
			brinquedo.setCategoria(brinquedoNovo.getCategoria());
			brinquedo.setMarca(brinquedoNovo.getMarca());

			// TRATAMENTO DA IMAGEM
			if (imagem != null && !imagem.isEmpty()) {

				String pasta = System.getProperty("user.dir") + "/uploads/toys/";
				File diretorio = new File(pasta);

				if (!diretorio.exists()) {
					diretorio.mkdirs();
				}

				String nomeArquivo = System.currentTimeMillis() + "_" + imagem.getOriginalFilename();
				Path caminho = Paths.get(pasta + nomeArquivo);

				Files.write(caminho, imagem.getBytes());

				System.out.println("Nova imagem salva em: " + caminho.toAbsolutePath());

				// Deleta imagem antiga
				if (brinquedo.getImagem() != null) {
					File antiga = new File(pasta + brinquedo.getImagem());
					if (antiga.exists()) {
						antiga.delete();
						System.out.println("Imagem antiga deletada");
					}
				}

				brinquedo.setImagem(nomeArquivo);
			}

			Brinquedo atualizado = brinquedoService.saveBrinquedo(brinquedo);

			System.out.println("Brinquedo atualizado: " + atualizado.getId());

			return ResponseEntity.ok(atualizado);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Erro interno: " + e.toString());
		}
	}

	// Deletar brinquedo
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		brinquedoService.deleteBrinquedo(id);
		return "Brinquedo Excluido com sucesso!";
	}

}
