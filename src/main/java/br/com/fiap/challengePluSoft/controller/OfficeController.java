package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping("/office/new")
	public String create(Office office) {
		return"officeNew";
	}
	@PostMapping("/offices")
	public String save(@Valid Office office, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "officeNew";
		}
		repository.save(office);
		redirect.addFlashAttribute("message","Departamento cadastrado com sucesso");
		return "redirect:offices";
	}
	
	
	
	
}
