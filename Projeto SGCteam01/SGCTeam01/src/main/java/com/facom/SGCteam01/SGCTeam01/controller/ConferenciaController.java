package com.facom.SGCteam01.SGCTeam01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConferenciaController {

	@RequestMapping(value = "/index")
	public String telaHome() {
		return "index";
	}

	@RequestMapping(value = "/confListagem")
	public String conferenciaListagem() {
		return "conferenciaListagem";
	}

}
