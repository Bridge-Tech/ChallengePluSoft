package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Phone;
import br.com.fiap.challengePluSoft.repository.PhoneRepositoy;

@Controller
public class PhoneController {

	private PhoneRepositoy repository;
	@GetMapping("/phones")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("phones");
		List<Phone> phones = repository.findAll(); 
		modelAndView.addObject("phones",phones);
		return modelAndView;
		
	}
}
