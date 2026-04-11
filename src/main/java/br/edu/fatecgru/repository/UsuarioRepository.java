package br.edu.fatecgru.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	// Achar usuário por email
	Optional<Usuario> findByEmail(String email);

}
