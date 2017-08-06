package com.facom.sgcteam01.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.facom.sgcteam01.model.Fase;
import com.facom.sgcteam01.repository.IConferenciaRepository;
import com.facom.sgcteam01.repository.IFaseRepository;

@Controller
public class FaseController {

	@Autowired
	private IFaseRepository iFaseRepository;

	@Autowired
	private IConferenciaRepository iConferenciaRepository;

	@RequestMapping("/cadastrarFase")
	public ModelAndView novaFase() {

		ModelAndView model = new ModelAndView("novaFase");
		model.addObject("conferencias", iConferenciaRepository.findAll());

		return new ModelAndView("novaFase");
	}

	@PostMapping("/fase/save")
	public String save(@RequestParam(name = "descricao") String descricao,
			@RequestParam(name = "dataInicio") String dataInicio, @RequestParam(name = "dataFim") String dataFim) {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicioFase;
		Date dataFimFase;
		Fase fase;

		try {

			dataInicioFase = formatDate.parse(dataInicio);
			dataFimFase = formatDate.parse(dataFim);

			fase = new Fase(descricao, dataInicioFase, dataFimFase);

			iFaseRepository.save(fase);

			return "redirect:/fase/list";
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
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
