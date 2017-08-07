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
import com.facom.sgcteam01.model.MembroComite;
import com.facom.sgcteam01.repository.IComiteRepository;
import com.facom.sgcteam01.repository.IMembroComiteRepositor;

@Controller
public class MembroComiteController {

	@Autowired
	private IMembroComiteRepositor iMembroComiteRepository;

	@Autowired
	private IComiteRepository iComiteRepository;

	MembroComite membroComiteEdit = new MembroComite();

	@RequestMapping("/membroComite/new")
	public ModelAndView novoMembro() {
		MembroComite membroComite = new MembroComite();

		List<Comite> comites = iComiteRepository.findAll();

		if (membroComiteEdit != null && membroComiteEdit.getId() != null)
			membroComite = membroComiteEdit;

		ModelAndView model = new ModelAndView("novoMembro");
		model.addObject("membroComite", membroComite);
		model.addObject("comites", comites);
		return model;
	}

	@PostMapping("/membroComite/save")
	public String save(MembroComite membroComite, BindingResult result) {

		iMembroComiteRepository.save(membroComite);

		if (membroComiteEdit != null && membroComiteEdit.getId() != null)
			membroComiteEdit = null;

		return "redirect:/membroComite/list";
	}

	@GetMapping("/membroComite/edit/{id}")
	public String edit(@PathVariable("id") Long id) {

		membroComiteEdit = iMembroComiteRepository.findOne(id);

		return "redirect:/membroComite/new";
	}

	@GetMapping("/membroComite/delete/{id}")
	public String delete(@PathVariable("id") Long id) {

		iMembroComiteRepository.delete(id);

		return "redirect:/membroComite/list";
	}

	@RequestMapping("/membroComite/list")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/listaMembro");
		mv.addObject("membros", iMembroComiteRepository.findAll());

		return mv;
	}

	@GetMapping("/membroComite/cancel")
	public String cancelar() {
		if (membroComiteEdit != null && membroComiteEdit.getId() != null)
			membroComiteEdit = null;

		return "redirect:/membroComite/list";
	}

}
