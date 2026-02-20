package com.senai.smartfila.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.smartfila.entities.Documentos;
import com.senai.smartfila.repositories.DocumentosRepository;

@Service
public class DocumentosService {

	@Autowired
	private DocumentosRepository repository;

	public List<Documentos> listarTodos() {
		return repository.findAll();
	}

	public Documentos buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Documentos salvar(Documentos documentos) {
		return repository.save(documentos);
	}

	public Documentos atualizar(Long id, Documentos documentos) {
		Documentos documentosExistente = buscarPorId(id);

		if (documentosExistente != null) {
			documentosExistente.setRg(documentos.getRg());
			documentosExistente.setCpf(documentos.getCpf());
			return repository.save(documentosExistente);
		}
		return null;
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}
}