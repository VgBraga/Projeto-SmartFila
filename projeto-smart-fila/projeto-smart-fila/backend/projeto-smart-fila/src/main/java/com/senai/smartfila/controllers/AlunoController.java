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

import com.senai.smartfila.entities.Aluno;
import com.senai.smartfila.services.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("*")
public class AlunoController {
	@Autowired
	private AlunoService service;

	@GetMapping
	public List<Aluno> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public Aluno buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public Aluno criar(@Valid @RequestBody Aluno aluno) {
		return service.salvar(aluno);
	}

	@PutMapping("/{id}")
	public Aluno atualizar(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
		return service.atualizar(id, aluno);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.deletar(id);
	}
}
