package br.com.fiap.challengePluSoft.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.challengePluSoft.model.Employee;
import br.com.fiap.challengePluSoft.repository.EmployeeRepository;
import br.com.fiap.challengePluSoft.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
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
	
	@PostMapping("/employees")
	public String save (@Valid Employee employee, BindingResult result,  RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			System.out.println("Não salvando Funcionário...");
			return "employeeNew";
		}
		employee.setIs_active(true);
		employee.setPassword(AuthenticationService.getPasswordEncoder().encode(employee.getPassword()));
		log.info(employee.toString());
		System.out.println("Salvando Fucionário...");
		repository.save(employee);
		return "redirect:login";
	}
	
	@GetMapping("/employee/delete/{id}")
	public ModelAndView confirmDestruction(@PathVariable Long id, RedirectAttributes redirect) {
		
		ModelAndView modelAndView = new ModelAndView("employeeDestroy");
		Optional<Employee> optional = repository.findById(id);
		
		if(optional.isEmpty()) {
		}
		Employee employee = optional.get();
			
		modelAndView.addObject("employeeDel", employee);
		return modelAndView;
	}
	
	@GetMapping("/employee/destroy/{id}")
	public String destroy(@PathVariable Long id, RedirectAttributes redirect) {
		Optional<Employee> optional = repository.findById(id);
		if (optional.isEmpty()) {
			redirect.addFlashAttribute("message","Funcionario deletado com Sucesso");
			return "redirect:employeeDestroy";
		}
		Employee employee = optional.get();
		log.info(employee.toString());
		employee.setIs_active(false);
		repository.save(employee); 
		redirect.addFlashAttribute("message","Funcionario deletado com Sucesso");
		return "redirect:/employees";
	}
	
	
}
