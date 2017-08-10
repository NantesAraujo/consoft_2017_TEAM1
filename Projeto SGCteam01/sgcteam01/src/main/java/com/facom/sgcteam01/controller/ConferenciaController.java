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
import com.facom.sgcteam01.repository.IMembroComiteRepositor;

@Controller
public class ConferenciaController {

	@Autowired
	private IMembroComiteRepositor iMembroComiteRepository;

	@Autowired
	private IConferenciaRepository iConferenciaRepository;

	Conferencia conferenciaEdit = new Conferencia();

	private boolean editable = true;

	@RequestMapping("/conferencia/new")
	public ModelAndView novaConferencia() {
		Conferencia conferencia = new Conferencia();

		if (conferenciaEdit != null && conferenciaEdit.getId() != null)
			conferencia = conferenciaEdit;

		ModelAndView model = new ModelAndView("novaConferencia");
		model.addObject("conferencia", conferencia);
		model.addObject("edicao", editable);

		return model;
	}

	@PostMapping("/conferencia/save")
	public String save(Conferencia conferencia, BindingResult result) {

		iConferenciaRepository.save(conferencia);

		if (conferenciaEdit != null && conferenciaEdit.getId() != null)
			conferenciaEdit = null;

		return "redirect:/conferencia/list";
	}

	@GetMapping("/conferencia/edit/{id}")
	public String edit(@PathVariable("id") Long id) {

		conferenciaEdit = iConferenciaRepository.findOne(id);

		return "redirect:/conferencia/new";
	}

	@GetMapping("/conferencia/view/{id}")
	public String view(@PathVariable("id") Long id) {

		conferenciaEdit = iConferenciaRepository.findOne(id);
		editable = false;

		return "redirect:/conferencia/new";
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

	@GetMapping("/conferencia/cancel")
	public String cancelar() {
		editable = true;
		if (conferenciaEdit != null && conferenciaEdit.getId() != null)
			conferenciaEdit = null;

		return "redirect:/conferencia/list";
	}
}
