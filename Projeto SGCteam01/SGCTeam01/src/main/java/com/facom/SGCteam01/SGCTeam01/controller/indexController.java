package com.facom.SGCteam01.SGCTeam01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

	@RequestMapping(value = "/teste")
	public String home() {
		return "home";
	}
}
