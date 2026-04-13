package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.model.dto.UsuarioCadastroDTO;
import br.edu.fatecgru.model.dto.UsuarioLoginDTO;
import br.edu.fatecgru.model.dto.UsuarioUpdateDTO;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
//Cria o geral, todos precisam desse
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> listarTodos() {
		return usuarioService.listarTodos();
	}

	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable int id) {
		return usuarioService.getById(id);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO dto) {
		try {
			Usuario usuario = usuarioService.login(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(usuario);

		} catch (Exception e) {
			return ResponseEntity.status(401).body(e.getMessage());
		}
	}

	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrar(@RequestBody UsuarioCadastroDTO cadastroRequest) {
		try {
			Usuario usuario = usuarioService.cadastrar(cadastroRequest.getNome(), cadastroRequest.getEmail(),
					cadastroRequest.getSenha());

			return ResponseEntity.ok(usuario);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody UsuarioUpdateDTO dto) {
		try {

			Usuario atual = usuarioService.getById(id);

			atual.setNome(dto.getNome());
			atual.setTelefone(dto.getTelefone());
			atual.setEndereco(dto.getEndereco());

			Usuario usuarioSalvo = usuarioService.saveUsuario(atual);

			return ResponseEntity.ok(usuarioSalvo);

		} catch (Exception e) {

			return ResponseEntity.status(500).body("Erro ao processar atualização: " + e.getMessage());
		}
	}

}
