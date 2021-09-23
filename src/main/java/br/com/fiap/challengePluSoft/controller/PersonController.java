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

import br.com.fiap.challengePluSoft.model.Person;
import br.com.fiap.challengePluSoft.repository.PersonRepository;


@Controller
public class PersonController {
		
	@Autowired
	private PersonRepository repository;
	
	@GetMapping("/people")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("people");
		List<Person> people = repository.findAll();
		modelAndView.addObject("people",people);
		return modelAndView;
	}
	
	@GetMapping("/person/new")
	public String personNew() {
		return "personNew";
	}
	
	@RequestMapping("/person/new/employee")
	public String create(Person person) {
		return "personNewEmployee";
	}

	@PostMapping("/person/new/employee")
	public String save (@Valid Person person, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Não salvando Pessoa...");
			return "personNewEmployee";
		}
		System.out.println("Salvando Pessoa...");
		repository.save(person);
		return "login";
	}
	

}
