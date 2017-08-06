package com.facom.sgcteam01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.facom.sgcteam01.model.Fase;
import com.facom.sgcteam01.repository.IFaseRepository;

@Controller
public class FaseController {

	@Autowired
	private IFaseRepository iFaseRepository;

	@PostMapping("/fase/save")
	public String save(Fase fase, BindingResult result) {

		iFaseRepository.save(fase);

		return "redirect:/fase/list";
	}

	@RequestMapping("/fase/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("editarFase");
		return mv;
	}

	@GetMapping("/fase/delete/{id}")
	public String delete(@PathVariable("id") Long id) {

		iFaseRepository.delete(id);

		return "redirect:/fase/list";
	}

	@RequestMapping("/fase/list")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/listaFase");
		mv.addObject("fases", iFaseRepository.findAll());

		return mv;
	}

}
