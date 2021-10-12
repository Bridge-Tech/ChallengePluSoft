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

import br.com.fiap.challengePluSoft.model.Patient;
import br.com.fiap.challengePluSoft.repository.PatientRepository;

@Controller
public class PatientController {
	@Autowired
	private PatientRepository repository;
	
	
	@GetMapping("/patients")
	public ModelAndView index() {
		
		ModelAndView modelAndView = new ModelAndView("patients");
		List<Patient> patients = repository.findAll();
		modelAndView.addObject("patients",patients);
		return modelAndView;
	}
	
	@RequestMapping("/patient/new")
	public String create(Patient patient) {
		return "patientNew";
	}
	
	@PostMapping("/patient")
	public String save (@Valid Patient patient, BindingResult result, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			System.out.println("Não salvando Funcionário...");
			return "patientNew";
		}
		
		System.out.println("Salvando Fucionário...");
		repository.save(patient);
		return "redirect:patients";
	}
	
	@GetMapping("/patient/analyzer/{id}")
	public ModelAndView analyzer(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("patientAnalyzer");
		Optional<Patient> patient =  repository.findById(id);
		modelAndView.addObject("patientAnalyzer",patient.get());
		return modelAndView;
	}
	
	@GetMapping("/patient/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("patientEdit");
		Optional<Patient> patient =  repository.findById(id);
		modelAndView.addObject("patientAnalyzer",patient.get());
		return modelAndView;
	}
	
	@GetMapping("/patient/delete/{id}")
	public String destroy(@PathVariable Long id) {
		Optional<Patient> patient = repository.findById(id);
		if (patient.isEmpty()) {
			return "patients";
		}
		repository.deleteById(id);
		
		return "patients";
	}
}
