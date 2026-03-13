package br.edu.fatecgru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.model.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

	// Método para fazer buscar por marca
	public List<Marca> findByNomeContains(String nome);
}
