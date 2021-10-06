package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Employee;
import br.com.fiap.challengePluSoft.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/empoyees")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("empoyees");
		List<Employee> l_employees = repository.findAll();	
		modelAndView.addObject("empoyees", l_employees);
		return modelAndView;
	}
	
	
	
	
}
