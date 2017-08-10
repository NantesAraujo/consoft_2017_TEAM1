package com.facom.sgcteam01.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conograma implements Serializable {

	private static final long serialVersionUID = 4096424118125101439L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "meioComunicacao")
	private String meioComunicacao;

	@Column(name = "data")
	private String data;

	@Column(name = "horario")
	private String horario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeioComunicacao() {
		return meioComunicacao;
	}

	public void setMeioComunicacao(String meioComunicacao) {
		this.meioComunicacao = meioComunicacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
}
