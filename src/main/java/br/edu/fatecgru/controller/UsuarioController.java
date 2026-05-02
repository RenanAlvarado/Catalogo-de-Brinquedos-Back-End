package br.edu.fatecgru.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.edu.fatecgru.mapper.EnderecoMapper;
import br.edu.fatecgru.model.dto.UsuarioAlterarSenhaDTO;
import br.edu.fatecgru.model.dto.UsuarioCadastroDTO;
import br.edu.fatecgru.model.dto.UsuarioLoginDTO;
import br.edu.fatecgru.model.dto.UsuarioUpdateDTO;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.security.JwtUtil;
import br.edu.fatecgru.service.ImagemService;
import br.edu.fatecgru.service.UsuarioService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
//Cria o geral, todos precisam desse
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ImagemService imagemService;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping
	public List<Usuario> listarTodos() {
		return usuarioService.listarTodos();
	}

	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable int id) {
		return usuarioService.getById(id);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UsuarioLoginDTO dto, BindingResult result) {

		if (result.hasErrors()) {
			return ResponseEntity.badRequest()
					.body(result.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList());
		}

		try {
			Usuario usuario = usuarioService.login(dto.getEmail(), dto.getSenha());

			String token = jwtUtil.gerarToken(usuario.getEmail(), usuario.getTipo().name());

			return ResponseEntity.ok(Map.of("token", token, "usuario", usuario));

		} catch (Exception e) {
			return ResponseEntity.status(401).body(e.getMessage());
		}
	}

	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrar(@Valid @RequestBody UsuarioCadastroDTO cadastroRequest, BindingResult result) {

		// validações automáticas do DTO
		if (result.hasErrors()) {
			Map<String, String> erros = new HashMap<>();

			for (FieldError error : result.getFieldErrors()) {
				erros.put(error.getField(), error.getDefaultMessage());
			}

			return ResponseEntity.badRequest().body(erros);
		}

		// validação de senha
		if (cadastroRequest.getSenha() != null
				&& !cadastroRequest.getSenha().equals(cadastroRequest.getConfirmarSenha())) {
			return ResponseEntity.badRequest().body("As senhas não coincidem");
		}

		try {
			Usuario usuario = usuarioService.cadastrar(cadastroRequest.getNome(), cadastroRequest.getEmail(),
					cadastroRequest.getSenha());

			return ResponseEntity.ok(usuario);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	// Método de atualizar o perfil
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @Valid @RequestBody UsuarioUpdateDTO dto,
			BindingResult result) {

		// erros de validação
		if (result.hasErrors()) {
			Map<String, String> erros = new HashMap<>();

			result.getFieldErrors().forEach(erro -> {
				erros.put(erro.getField(), erro.getDefaultMessage());
			});

			return ResponseEntity.badRequest().body(erros);
		}

		try {
			Usuario atual = usuarioService.getById(id);

			atual.setNome(dto.getNome());
			atual.setTelefone(dto.getTelefone());

			if (dto.getEndereco() != null) {
				atual.setEndereco(EnderecoMapper.toEntity(dto.getEndereco()));
			}

			Usuario usuarioSalvo = usuarioService.saveUsuario(atual);

			return ResponseEntity.ok(usuarioSalvo);

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro ao atualizar usuário");
		}
	}

	// Pasta do usuário para salvar
	String pastaUsuarios = "usuarios/";

	@PutMapping("/{id}/imagem")
	public ResponseEntity<?> atualizarImagem(@PathVariable Integer id, @RequestParam("imagem") MultipartFile imagem) {
		try {
			Usuario usuario = usuarioService.getById(id);

			String novaImagem = imagemService.substituirImagem(usuario.getImagem(), imagem);

			usuario.setImagem(novaImagem);

			Usuario atualizado = usuarioService.saveUsuario(usuario);

			return ResponseEntity.ok(atualizado);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@PutMapping("/{id}/senha")
	public ResponseEntity<?> alterarSenha(@PathVariable Integer id, @RequestBody @Valid UsuarioAlterarSenhaDTO dto,
			BindingResult result) {

		try {

			// validações do Bean Validation
			if (result.hasErrors()) {
				Map<String, String> erros = new HashMap<>();

				for (FieldError error : result.getFieldErrors()) {
					erros.put(error.getField(), error.getDefaultMessage());
				}

				return ResponseEntity.badRequest().body(erros);
			}

			// validação de confirmação
			if (!dto.getSenha().equals(dto.getConfirmarSenha())) {
				return ResponseEntity.badRequest().body("As senhas não coincidem");
			}

			usuarioService.alterarSenha(id, dto);

			Map<String, String> resposta = new HashMap<>();
			resposta.put("message", "Senha alterada com sucesso");

			return ResponseEntity.ok(resposta);

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro ao alterar senha: " + e.getMessage());
		}
	}
}
