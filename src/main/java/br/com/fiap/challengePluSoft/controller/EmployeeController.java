package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	private EmployeeRepository repository;
	
	@GetMapping("/empoyees")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("empoyees");
		List<EmployeeController> l_employees = repository.findAll();	
		modelAndView.addObject("empoyees", l_employees);
		return modelAndView;
	}
	
	
}
