package br.edu.fatecgru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
