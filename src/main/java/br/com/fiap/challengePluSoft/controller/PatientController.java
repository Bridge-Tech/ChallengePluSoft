package br.com.fiap.challengePluSoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.challengePluSoft.exception.NotAllowedException;
import br.com.fiap.challengePluSoft.exception.PatientNotFoundException;
import br.com.fiap.challengePluSoft.model.Employee;
import br.com.fiap.challengePluSoft.model.Patient;
import br.com.fiap.challengePluSoft.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
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
			System.out.println("Não salvando Paciente...");
			redirect.addFlashAttribute("message","Não foi possivel adicionar o Paciente!");
			return "patientNew";
			
		}
		patient.setIs_active(true);
		System.out.println("Salvando Paciente...");
		redirect.addFlashAttribute("message","Paciente adicionado com Sucesso!");
		repository.save(patient);
		return "redirect:patients";
	}
	
	@GetMapping("/patient/analyzer/{id}")
	public ModelAndView analyzer(@PathVariable Long id, RedirectAttributes redirect) {
		ModelAndView modelAndView = new ModelAndView("patientAnalyzer");
		Optional<Patient> optional =  repository.findById(id);
		
		if(optional.isEmpty()) {
			modelAndView.addObject("redirect:patients");
			return modelAndView;
		}
		
		Patient patient = optional.get();
		log.info(patient.toString());
		modelAndView.addObject("patientAnalyzer",patient);
		return modelAndView;
	}
	
	@GetMapping("/patient/edit/{id}")
	public ModelAndView confirmEdit(@PathVariable Long id, RedirectAttributes redirect) {
		
		ModelAndView modelAndView = new ModelAndView("patientEdit");
		Optional<Patient> optional =  repository.findById(id);
		if(optional.isEmpty()) {	
		}
		Patient patient = optional.get();
		modelAndView.addObject("patientEdit",patient);
		return modelAndView;
	}
	
	@PostMapping("/patient/edit")
	public String edit(@Valid Patient patientEdit, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			System.out.println("Não salvando Paciente...");
			return "patientEdit";
		}
		log.info(patientEdit.toString());
		Optional<Patient> optional = repository.findById(patientEdit.getId());
		if(optional.isEmpty()) {
			return "patientEdit";
		}
		Patient patient = optional.get();
		patient.setBirthdate(patient.getBirthdate());
		patient.setName(patientEdit.getName());
		System.out.println("Salvando Paciente...");
		repository.save(patient);
		return "redirect:patients";
	}
	
	
	
	
	@GetMapping("/patient/delete/{id}")
	public ModelAndView confirmDestruction(@PathVariable Long id, RedirectAttributes redirect) {
		
		ModelAndView modelAndView = new ModelAndView("patientDestroy");
		Optional<Patient> optional = repository.findById(id);
		
		if(optional.isEmpty()) {
		}
		Patient patient = optional.get();
			
		modelAndView.addObject("patientDel", patient);
		return modelAndView;
	} 
	
	@GetMapping("/patient/destroy/{id}")
	public String destroy(@PathVariable Long id, RedirectAttributes redirect) {
		Optional<Patient> optional = repository.findById(id);
		if (optional.isEmpty()) {
			redirect.addFlashAttribute("message","Não foi possivel desabilitar o Paciente");
			return "redirect:patientDestroy";
		}
		Patient patient = optional.get();
		log.info(patient.toString());
		patient.setIs_active(false);
		repository.save(patient); 
		redirect.addFlashAttribute("message","Paciente desabilitado com Sucesso");
		return "redirect:/patients";
	}

	@GetMapping("/patient/startTreatment/{id}")
	public String start(@PathVariable Long id, Authentication auth) {
		Optional<Patient> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new PatientNotFoundException("Paciente não encontrado!");
		}
		
		Patient patient = optional.get();
		
		if (patient.getEmployee() != null) {
			throw new NotAllowedException("Paciente ja iniciou o tratamento!");
		}
		
		Employee employee = (Employee) auth.getPrincipal();
		patient.setEmployee(employee);
		repository.save(patient);
		System.out.println("UPDATE PASSIENTE");
		log.info(patient.toString());
		return "redirect:/patients";
	}
	
	@GetMapping("/patient/stopTreatment/{id}")
	public String stop(@PathVariable Long id, Authentication auth) {
		Optional<Patient> optional = repository.findById(id);
		
		if (optional.isEmpty()) {
			throw new PatientNotFoundException("Paciente não encontrado!");
		}
		
		Patient patient = optional.get();
		Employee employee = (Employee) auth.getPrincipal();
		
		if (!patient.getEmployee().equals(employee)) {
			throw new NotAllowedException("Esse Paciente não esta atribuido a você!");
		} 
		
		
		patient.setEmployee(null);
		repository.save(patient);
		return "redirect:/patients";
	}
	
	
}
