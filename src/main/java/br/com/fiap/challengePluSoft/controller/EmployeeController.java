package br.com.fiap.challengePluSoft.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Employee;
import br.com.fiap.challengePluSoft.repository.EmployeeRepository;
import br.com.fiap.challengePluSoft.service.AuthenticationService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/employees")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("employees");
		List<Employee> l_employees = repository.findAll();	
		modelAndView.addObject("employees", l_employees);
		return modelAndView;
	}
	
	
	@RequestMapping("/employee/new")
	public String create(Employee employee) {
		return "employeeNew";
	}
	
	@PostMapping("/employee")
	public String save (@Valid Employee employee, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Não salvando Funcionário...");
			return "employeeNew";
		}
		employee.setPassword(AuthenticationService.getPasswordEncoder().encode(employee.getPassword()));
		System.out.println("Salvando Fucionário...");
		repository.save(employee);
		return "login";
	}
	
	
	@GetMapping("/employee/delete/{id}")
	public String destroy(@PathVariable Long id) {
		Optional<Employee> employee = repository.findById(id);
		if (employee.isEmpty()) {
			return "employees";
		}
		repository.deleteById(id);
		
		return "employees";
	}
	
	
}
