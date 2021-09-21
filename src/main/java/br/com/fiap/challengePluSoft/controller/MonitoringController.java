package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Monitoring;
import br.com.fiap.challengePluSoft.repository.MonitoringRepository;

@Controller
public class MonitoringController {

	private MonitoringRepository repository;
	@GetMapping("/monitoring")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("monitoring");
		List<Monitoring> l_monitoring = repository.findAll();
		modelAndView.addObject("monitoring",l_monitoring);
		return modelAndView;
	}
	
	
}
