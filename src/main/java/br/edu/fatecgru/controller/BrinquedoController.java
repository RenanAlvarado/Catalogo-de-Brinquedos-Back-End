package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.model.entity.Brinquedo;
import br.edu.fatecgru.service.BrinquedoService;

@RestController
//Cria o geral, todos precisam desse
@RequestMapping("/api/brinquedos")
public class BrinquedoController {

	@Autowired
	private BrinquedoService brinquedoService;

	@GetMapping
	public List<Brinquedo> listarTodos() {
		return brinquedoService.listarTodos();
	}

}
