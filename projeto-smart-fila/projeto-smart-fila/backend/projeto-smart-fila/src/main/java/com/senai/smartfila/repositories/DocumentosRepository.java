package com.senai.smartfila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.smartfila.entities.Documentos;

public interface DocumentosRepository extends JpaRepository<Documentos, Long> {

}
