package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Role;
import br.com.fiap.challengePluSoft.repository.RoleRepository;

@Controller
public class RoleController {
	
	@Autowired
	private RoleRepository repository;
	
	@GetMapping("/roles")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("roles");
		List<Role> roles = repository.findAll();
		modelAndView.addObject("roles",roles);
		return modelAndView;
	}
	
	
}
