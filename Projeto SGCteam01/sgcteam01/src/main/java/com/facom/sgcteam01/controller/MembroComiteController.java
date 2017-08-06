package com.facom.sgcteam01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.facom.sgcteam01.model.MembroComite;
import com.facom.sgcteam01.repository.IMembroComiteRepositor;

@Controller
public class MembroComiteController {

	@Autowired
	private IMembroComiteRepositor iMembroComiteRepository;

	@RequestMapping("/cadastrarMembroComite")
	public String novaConferencia() {
		return "novoMembro";
	}

	@PostMapping("/membroComite/save")
	public String save(MembroComite membroComite, BindingResult result) {

		iMembroComiteRepository.save(membroComite);

		return "redirect:/membroComite/list";
	}

	@GetMapping("/membroComite/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		ModelAndView model = new ModelAndView();
		model.addObject("membroComite", iMembroComiteRepository.findOne(id));

		return model;
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

}
