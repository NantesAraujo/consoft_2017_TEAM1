package com.facom.sgcteam01.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comite implements Serializable {

	private static final long serialVersionUID = 4096424118125101439L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	@OneToMany(mappedBy = "comite")
	private List<MembroComite> membros;

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private String getDescricao() {
		return descricao;
	}

	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private List<MembroComite> getMembros() {
		return membros;
	}

	private void setMembros(List<MembroComite> membros) {
		this.membros = membros;
	}
}
