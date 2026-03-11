package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.Marca;
import br.edu.fatecgru.repository.MarcaRepository;

@Service
public class MarcaService {

	// Método de puxar todos para realização do teste
	@Autowired
	private MarcaRepository marcaRepository;

	public List<Marca> listarTodos() {
		return marcaRepository.findAll();
	}

	// Consulta por marca que contém no nome
	public List<Marca> getByContainsName(String nome) {
		return marcaRepository.findByNomeContains(nome);
	}

}
