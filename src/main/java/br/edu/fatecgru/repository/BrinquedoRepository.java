package br.edu.fatecgru.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.fatecgru.model.entity.Brinquedo;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Integer> {

	// Para gerar um método
	public Brinquedo findByNome(String nome);

	public List<Brinquedo> findByNomeContains(String nome);

	public List<Brinquedo> findByCategoriaId(int categoriaId);

	public List<Brinquedo> findByMarcaId(int marcaId);

	// Método para fazer paginação
	Page<Brinquedo> findAll(Pageable pageable);

	// Ordenação
	@Query("""
			SELECT b FROM Brinquedo b
			WHERE (:categorias IS NULL OR b.categoria.id IN :categorias)
			AND (:marcas IS NULL OR b.marca.id IN :marcas)
			""")
	Page<Brinquedo> filtrar(@Param("categorias") List<Long> categorias, @Param("marcas") List<Long> marcas,
			Pageable pageable);

}
