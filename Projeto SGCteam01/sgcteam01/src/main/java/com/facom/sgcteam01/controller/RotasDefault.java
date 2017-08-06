package com.facom.sgcteam01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RotasDefault {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/cadastrarConferencia")
	public String novaConferencia() {
		return "novaConferencia";
	}

	@RequestMapping("/cadastrarFase")
	public String novaFase() {
		return "novaFase";
	}
}
