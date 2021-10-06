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
	
	
	@RequestMapping("/role/new")
	public String create(Role role) {
		return"roleNew";
	}
	@PostMapping("/roles")
	public String save(@Valid Role role, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "roleNew";
		}
		repository.save(role);
		redirect.addFlashAttribute("message","Função cadastrada com sucesso");
		return "redirect:roles";
	}
	
	
}
