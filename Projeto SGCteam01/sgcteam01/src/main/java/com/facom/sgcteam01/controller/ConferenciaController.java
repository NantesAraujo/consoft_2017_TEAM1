package com.facom.sgcteam01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facom.sgcteam01.model.Conferencia;
import com.facom.sgcteam01.repository.IConferenciaRepository;

@Controller
public class ConferenciaController {

	@Autowired
	private IConferenciaRepository iConferenciaRepository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/conferencia")
	public String abrirConferencia() {
		return "cadastrarConferencia";
	}

	@RequestMapping("/listarConferencia")
	public String mostrarConferencias(Model model) {

		Iterable<Conferencia> listaConferencia = iConferenciaRepository.findAll();
		model.addAttribute("conferencias", listaConferencia);

		return "listaConf";
	}

}
