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
	
	
	@RequestMapping("/permission/new")
	public String create(Permission permission) {
		return"permissionNew";
	}
	@PostMapping("/permissions")
	public String save(@Valid Permission permission, BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return "permissionNew";
		}
		repository.save(permission);
		redirect.addFlashAttribute("message","Permissão cadastrada com sucesso");
		return "redirect:permissions";
	}
	
	
	
	@GetMapping("/permission/edit/{id}")
	public ModelAndView permissionEdit(@PathVariable Long id) {
		
		ModelAndView modelAndView = new ModelAndView("permissionEdit");
		Optional<Permission> optional = repository.findById(id);
		Permission permissions  = optional.get();
		modelAndView.addObject("permissionEdit", permissions);
		return modelAndView;
	}
	
	
	@PostMapping("/permission/edit/{id}")
	public String edit(@Valid Permission newPermission, BindingResult result, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			return "permissionEdit";
		}
		Permission permission = newPermission;
		permission.setName(newPermission.getName());
		permission.setDescription(newPermission.getDescription());


		repository.save(permission); 
		redirect.addFlashAttribute("message","Permissão atualizada com sucesso");
		return "redirect:permissions";
	}
	
	
	
	
	
}

