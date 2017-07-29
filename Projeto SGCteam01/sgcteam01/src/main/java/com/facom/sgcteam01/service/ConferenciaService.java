package com.facom.sgcteam01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facom.sgcteam01.model.Conferencia;
import com.facom.sgcteam01.repository.IConferenciaRepository;

@Service
public class ConferenciaService {

	@Autowired
	private IConferenciaRepository iConferenciaRepository;

	public List<Conferencia> buscarTodos() {
		return iConferenciaRepository.findAll();
	}

	public Conferencia buscarPorId(Long id) {
		return iConferenciaRepository.findOne(id);
	}

	public Conferencia salvar(Conferencia post) {
		return iConferenciaRepository.saveAndFlush(post);
	}

	public void deletar(Long id) {
		iConferenciaRepository.delete(id);
	}

	public Conferencia Atualizar(Conferencia conferencia) {
		return iConferenciaRepository.save(conferencia);
	}
}
