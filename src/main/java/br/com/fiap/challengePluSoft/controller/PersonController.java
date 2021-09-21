package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Person;
import br.com.fiap.challengePluSoft.repository.PersonRepository;

@Controller
public class PersonController {

	private PersonRepository repository;
	@GetMapping("/people")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("people");
		List<Person> people = repository.findAll();
		modelAndView.addObject("people",people);
		return modelAndView;
	}
}
