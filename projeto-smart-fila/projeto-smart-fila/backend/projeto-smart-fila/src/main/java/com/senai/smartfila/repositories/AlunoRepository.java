package com.senai.smartfila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.smartfila.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
