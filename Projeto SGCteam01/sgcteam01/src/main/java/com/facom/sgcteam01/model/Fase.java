package com.facom.sgcteam01.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fase implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String descricao;

	@Column
	private Date dataInicio;

	@Column
	private Date dataFim;

	// @ManyToOne
	// @JoinColumn(name = "conferencia_id", referencedColumnName = "id")
	// private Conferencia conferencia;

	public Fase() {
	}

	public Fase(String descricao, Date dataInicioFase, Date dataFimFase) {
		this.descricao = descricao;
		this.dataInicio = dataInicioFase;
		this.dataFim = dataFimFase;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	// public Conferencia getConferencia() {
	// return conferencia;
	// }
	//
	// public void setConferencia(Conferencia conferencia) {
	// this.conferencia = conferencia;
	// }
}
