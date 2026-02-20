package com.senai.smartfila.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.smartfila.entities.Aluno;
import com.senai.smartfila.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;

	public List<Aluno> listarTodos() {
		return repository.findAll();
	}

	public Aluno buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Aluno salvar(Aluno aluno) {
		return repository.save(aluno);
	}

	public Aluno atualizar(Long id, Aluno dados) {
		Aluno existente = buscarPorId(id);
		existente.setNome(dados.getNome());
		existente.setTurma(dados.getTurma());
		existente.setRa(dados.getRa());
		existente.setDocumentos(dados.getDocumentos	());

		return repository.save(existente);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}
}