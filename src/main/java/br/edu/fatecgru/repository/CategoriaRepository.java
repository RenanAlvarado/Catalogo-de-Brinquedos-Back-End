package br.edu.fatecgru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.model.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
