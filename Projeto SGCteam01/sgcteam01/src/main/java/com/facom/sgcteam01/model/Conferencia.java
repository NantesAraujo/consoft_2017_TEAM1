package com.facom.sgcteam01.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conferencia implements Serializable {

	private static final long serialVersionUID = 1230694956112443874L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "idioma")
	private String idioma;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "topicoGerais")
	private String topicoGerais;

	@Column(name = "paginaWeb")
	private String paginaWeb;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	private String estado;

	@Column(name = "nomeOrganizador")
	private String nomeOrganizador;

	@Column(name = "emailContato")
	private String emailContato;

	@Column(name = "tiposSubmissoes")
	private String tiposSubmissoes;

	@Column(name = "participante")
	private String participante;

	@Column(name = "tipoEventos")
	private String tipoEventos;

	public Conferencia() {
	}

	public Conferencia(String idioma, String titulo, String topicoGerais, String paginaWeb, String descricao,
			String cidade, String estado, String nomeOrganizador, String emailContato, Date dataInicio, Date dataFim) {
		this.idioma = idioma;
		this.titulo = titulo;
		this.topicoGerais = topicoGerais;
		this.paginaWeb = paginaWeb;
		this.descricao = descricao;
		this.cidade = cidade;
		this.estado = estado;
		this.nomeOrganizador = nomeOrganizador;
		this.emailContato = emailContato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTopicoGerais() {
		return topicoGerais;
	}

	public void setTopicoGerais(String topicoGerais) {
		this.topicoGerais = topicoGerais;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomeOrganizador() {
		return nomeOrganizador;
	}

	public void setNomeOrganizador(String nomeOrganizador) {
		this.nomeOrganizador = nomeOrganizador;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getTiposSubmissoes() {
		return tiposSubmissoes;
	}

	public void setTiposSubmissoes(String tiposSubmissoes) {
		this.tiposSubmissoes = tiposSubmissoes;
	}

	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}

	public String getTipoEventos() {
		return tipoEventos;
	}

	public void setTipoEventos(String tipoEventos) {
		this.tipoEventos = tipoEventos;
	}
}