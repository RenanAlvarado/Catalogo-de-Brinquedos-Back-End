package br.edu.fatecgru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.model.entity.Brinquedo;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Integer> {

	//	Para gerar um método
	public Brinquedo findByNome(String nome);

	public List<Brinquedo> findByNomeContains(String nome);

	public List<Brinquedo> findByCategoriaId(int categoriaId);
}
