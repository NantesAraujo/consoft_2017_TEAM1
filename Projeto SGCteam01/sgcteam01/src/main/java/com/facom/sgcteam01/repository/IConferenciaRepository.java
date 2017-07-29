package com.facom.sgcteam01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facom.sgcteam01.model.Conferencia;

public interface IConferenciaRepository extends JpaRepository<Conferencia, Long> {
}
