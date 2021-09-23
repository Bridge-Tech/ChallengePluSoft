package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Permission;
import br.com.fiap.challengePluSoft.repository.PermissionRepoesitory;

@Controller
public class PermissionController {

	@Autowired
	private PermissionRepoesitory repository;
	
	@GetMapping("/permissions")
	public ModelAndView index() {
		 ModelAndView modelAndView = new ModelAndView("permissions");
		List<Permission> permissions = repository.findAll();
		modelAndView.addObject("permissions",permissions);
		return modelAndView;
	}
	
	
	
	
}

