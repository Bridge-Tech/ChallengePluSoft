package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Office;
import br.com.fiap.challengePluSoft.repository.OfficeRepository;

@Controller
public class OfficeController {

	@Autowired
	private OfficeRepository repository;
	
	@GetMapping("/offices")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("offices");
		List<Office> offices = repository.findAll();
		modelAndView.addObject("offices", offices);
		return modelAndView;
	}
	
	
}
