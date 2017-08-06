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

	@PostMapping("/comite/save")
	public String save(Comite comite, BindingResult result) {

		iComiteRepository.save(comite);

		return "redirect:/comite/list";
	}

	@GetMapping("/comite/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		ModelAndView model = new ModelAndView();
		model.addObject("conferencia", iComiteRepository.findOne(id));

		return model;
	}

	@GetMapping("/comite/delete/{id}")
	public String delete(@PathVariable("id") Long id) {

		iComiteRepository.delete(id);

		return "redirect:/comite/list";
	}

	@RequestMapping("/comite/list")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/comite/list");
		mv.addObject("conferencias", iComiteRepository.findAll());

		return mv;
	}

}
