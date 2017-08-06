package com.facom.sgcteam01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.facom.sgcteam01.model.Conferencia;
import com.facom.sgcteam01.repository.IConferenciaRepository;

@Controller
public class ConferenciaController {

	@Autowired
	private IConferenciaRepository iConferenciaRepository;

	@PostMapping("/conferencia/save")
	public String save(Conferencia conferencia, BindingResult result) {

		iConferenciaRepository.save(conferencia);

		return "redirect:/conferencia/list";
	}

	@RequestMapping("/conferencia/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("editarConferencia");
		return mv;
	}

	@GetMapping("/conferencia/delete/{id}")
	public String delete(@PathVariable("id") Long id) {

		iConferenciaRepository.delete(id);

		return "redirect:/conferencia/list";
	}

	@RequestMapping("/conferencia/list")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/listaConferencia");
		mv.addObject("conferencias", iConferenciaRepository.findAll());

		return mv;
	}
}
