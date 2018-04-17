package com.example.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contatos.model.Contatos;

public interface ContatosRepository extends JpaRepository<Contatos, Long>{

}
