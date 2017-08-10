package com.facom.sgcteam01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.facom.sgcteam01.model.Comite;
import com.facom.sgcteam01.repository.IComiteRepository;

@Controller
public class ComiteController {

	@Autowired
	private IComiteRepository iComiteRepository;

	Comite comiteEdit = new Comite();

	@RequestMapping("/comite/new")
	public ModelAndView novoComite() {
		Comite comite = new Comite();

		if (comiteEdit != null && comiteEdit.getId() != null)
			comite = comiteEdit;

		ModelAndView model = new ModelAndView("novoComite");
		model.addObject("comite", comite);
		return model;
	}

	@PostMapping("/comite/save")
	public String save(Comite comite, BindingResult result) {

		iComiteRepository.save(comite);

		if (comiteEdit != null && comiteEdit.getId() != null)
			comiteEdit = null;

		return "redirect:/comite/list";
	}

	@GetMapping("/comite/edit/{id}")
	public String edit(@PathVariable("id") Long id) {

		comiteEdit = iComiteRepository.findOne(id);

		return "redirect:/comite/new";
	}

	@GetMapping("/comite/delete/{id}")
	public String delete(@PathVariable("id") Long id) {

		iComiteRepository.delete(id);

		return "redirect:/comite/list";
	}

	@RequestMapping("/comite/list")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/listaComite");
		mv.addObject("comites", iComiteRepository.findAll());

		return mv;
	}

	@GetMapping("/comite/cancel")
	public String cancelar() {
		if (comiteEdit != null && comiteEdit.getId() != null)
			comiteEdit = null;

		return "redirect:/comite/list";
	}

}
