package com.facom.sgcteam01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.facom.sgcteam01.model.Comite;
import com.facom.sgcteam01.model.Conograma;
import com.facom.sgcteam01.repository.IComiteRepository;
import com.facom.sgcteam01.repository.IConogramaRepositor;

@Controller
public class ConogramaController {

	@Autowired
	private IConogramaRepositor iConogramaRepositor;

	@Autowired
	private IComiteRepository iComiteRepository;

	Conograma conogramaEdit = new Conograma();

	@RequestMapping("/conograma/new")
	public ModelAndView novoConograma() {
		Conograma conograma = new Conograma();

		List<Comite> comites = iComiteRepository.findAll();

		if (conogramaEdit != null && conogramaEdit.getId() != null)
			conograma = conogramaEdit;

		ModelAndView model = new ModelAndView("novoConograma");
		model.addObject("conograma", conograma);
		model.addObject("comites", comites);
		return model;
	}

	@PostMapping("/conograma/save")
	public String save(Conograma conograma, BindingResult result) {

		iConogramaRepositor.save(conograma);

		if (conogramaEdit != null && conogramaEdit.getId() != null)
			conogramaEdit = null;

		return "redirect:/conograma/list";
	}

	@GetMapping("/conograma/edit/{id}")
	public String edit(@PathVariable("id") Long id) {

		conogramaEdit = iConogramaRepositor.findOne(id);

		return "redirect:/conograma/new";
	}

	@GetMapping("/conograma/delete/{id}")
	public String delete(@PathVariable("id") Long id) {

		iConogramaRepositor.delete(id);

		return "redirect:/conograma/list";
	}

	@RequestMapping("/conograma/list")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/listaConograma");
		mv.addObject("conogramas", iConogramaRepositor.findAll());

		return mv;
	}

	@GetMapping("/conograma/cancel")
	public String cancelar() {
		if (conogramaEdit != null && conogramaEdit.getId() != null)
			conogramaEdit = null;

		return "redirect:/conograma/list";
	}

}
