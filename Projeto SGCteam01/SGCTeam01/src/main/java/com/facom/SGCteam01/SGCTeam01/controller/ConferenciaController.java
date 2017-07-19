package com.facom.SGCteam01.SGCTeam01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConferenciaController {

	// @Autowired
	// private ConferenciaService conferenciaService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// @RequestMapping(value = "/conferenciaTodos", method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
	// public List<Conferencia> teste() {
	// List<Conferencia> lista = conferenciaService.buscarTodos();
	//
	// return lista;
	// }
	//
	// @RequestMapping(value = "/conferenciaNovo", method = RequestMethod.POST)
	// public String novoTeste() {
	// Conferencia conferencia = new Conferencia();
	// conferencia.setNome("conferencia de teste 1");
	// conferencia.setSubTitulo("conferencia sub titulo 1");
	// conferencia.setPaginaWeb("www.google.com.br/conferencia");
	// conferencia.setCidade("Campo Grande");
	// conferencia.setDataFim(new Date());
	// conferencia.setDataFim(new Date());
	// conferencia.setEmailContato("thiago-nunes-16@hotmail.com");
	//
	// conferencia = conferenciaService.salvar(conferencia);
	//
	// return (conferencia.getId() != null ? "salvo com sucesso" : "");
	// }
	//
	// @RequestMapping(value = "/deletarConferencia", method =
	// RequestMethod.DELETE)
	// public String deletar(@RequestParam(value = "id", required = true) Long
	// id) {
	// Conferencia conferencia = conferenciaService.buscarPorId(id);
	//
	// conferenciaService.deletar(id);
	//
	// return "Conferencia de id: " + conferencia.getId() + " removida com
	// sucesso.";
	// }
}
