package br.edu.fatecgru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.model.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	// Método para fazer buscar por categoria
	public List<Categoria> findByNomeContains(String nome);
	
}
