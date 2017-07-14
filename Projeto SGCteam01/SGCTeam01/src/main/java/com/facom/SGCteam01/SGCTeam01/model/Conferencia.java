package com.facom.SGCteam01.SGCTeam01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String nomeConferencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeConferencia() {
		return nomeConferencia;
	}

	public void setNomeConferencia(String nomeConferencia) {
		this.nomeConferencia = nomeConferencia;
	}
}
