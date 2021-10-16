package br.com.fiap.challengePluSoft.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.challengePluSoft.model.Employee;
import br.com.fiap.challengePluSoft.model.Note;
import br.com.fiap.challengePluSoft.repository.NoteRepository;

@Controller
public class NoteController {
	
	@Autowired
	private NoteRepository repository;
	
	@RequestMapping("/note/new")
	public String create(Note note) {
		return "noteNew";
	}
	
	@PostMapping("/notes")
	public String save (@Valid Note note, BindingResult result, Authentication auth ,RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			System.out.println("Não salvando Comentário...");
			return "noteNew";
		}
		LocalDate today = LocalDate.now();
		note.setDate(today.toString());
		Employee employee = (Employee) auth.getPrincipal();
		note.setEmployee(employee);
		System.out.println("Salvando Comentário...");
		repository.save(note);
		redirect.addFlashAttribute("message","Função cadastrada com sucesso");
		return "redirect:patients";
	}
}
