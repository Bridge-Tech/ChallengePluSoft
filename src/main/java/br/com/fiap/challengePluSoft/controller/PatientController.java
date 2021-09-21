package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Patient;
import br.com.fiap.challengePluSoft.repository.PatientRepository;

@Controller
public class PatientController {

	private PatientRepository repository;
	@GetMapping("/patients")
	public ModelAndView index() {
		
		ModelAndView modelAndView = new ModelAndView("patients");
		List<Patient> patients = repository.findAll();
		modelAndView.addObject("patients",patients);
		return modelAndView;
	}
	
	
}
