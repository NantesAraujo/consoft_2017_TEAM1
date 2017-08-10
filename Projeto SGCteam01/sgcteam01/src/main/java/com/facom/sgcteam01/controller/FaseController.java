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

	private boolean editable = true;

	private Fase faseEdit;

	@RequestMapping("/fase/new")
	public ModelAndView novaFase() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Fase fase = new Fase();

		if (faseEdit != null && faseEdit.getId() != null) {
			fase = new Fase(faseEdit.getDescricao(), faseEdit.getDataInicio(), faseEdit.getDataFim());
		}

		ModelAndView model = new ModelAndView("novaFase");
		model.addObject("fase", fase);
		model.addObject("edicao", editable);

		return model;
	}

	@PostMapping("/fase/save")
	public String save(@RequestParam(name = "descricao") String descricao,
			@RequestParam(name = "dataInicio") String dataInicio, @RequestParam(name = "dataFim") String dataFim) {

		Fase fase = new Fase(descricao, dataInicio, dataFim);

		iFaseRepository.save(fase);

		return "redirect:/fase/list";
	}

	private Date formatarData(String data) {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formatDate.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/fase/edit/{id}")
	public String edit(@PathVariable Long id) {

		faseEdit = iFaseRepository.findOne(id);

		return "redirect:/fase/new";
	}

	@GetMapping("/fase/view/{id}")
	public String view(@PathVariable("id") Long id) {

		faseEdit = iFaseRepository.findOne(id);
		editable = false;

		return "redirect:/fase/new";
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

	@GetMapping("/fase/cancel")
	public String cancelar() {
		editable = true;
		if (faseEdit != null && faseEdit.getId() != null)
			faseEdit = null;

		return "redirect:/fase/list";
	}

}
