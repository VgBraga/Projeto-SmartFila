package com.senai.smartfila.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.smartfila.entities.Turma;
import com.senai.smartfila.repositories.TurmaRepository;
@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;

	public List<Turma> listarTodos() {
		return repository.findAll();
	}

	public Turma buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Turma salvar(Turma turma) {
		return repository.save(turma);
	}

	public Turma atualizar(Long id, Turma turma) {
		Turma turmaExistente = buscarPorId(id);
	if(turmaExistente != null) {
		turmaExistente.setNome(turma.getNome());
		turmaExistente.setAlunos(turma.getAlunos());
		return repository.save(turmaExistente);
	}
	return null;
}

	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
