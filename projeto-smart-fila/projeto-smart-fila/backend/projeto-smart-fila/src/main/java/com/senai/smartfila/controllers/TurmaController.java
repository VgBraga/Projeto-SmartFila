package com.senai.smartfila.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.smartfila.entities.Turma;
import com.senai.smartfila.services.TurmaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turma")
@CrossOrigin("*")
public class TurmaController {

	@Autowired
	private TurmaService service;

	@GetMapping
	public List<Turma> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public Turma buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public Turma criar(@Valid @RequestBody Turma turma) {
		return service.salvar(turma);
	}

	@PutMapping("/{id}")
	public Turma atualizar(@PathVariable Long id, @Valid @RequestBody Turma turma) {
		return service.atualizar(id, turma);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.deletar(id);
	}
}
