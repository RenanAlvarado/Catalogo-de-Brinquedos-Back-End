package br.edu.fatecgru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.model.entity.Brinquedo;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Integer> {

}
