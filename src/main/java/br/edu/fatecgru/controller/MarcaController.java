package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.model.entity.Marca;
import br.edu.fatecgru.service.MarcaService;

@CrossOrigin(origins = "*")
@RestController
//Cria o geral, todos precisam desse
@RequestMapping("/api/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@GetMapping
	public List<Marca> listarTodos() {
		return marcaService.listarTodos();
	}

}
