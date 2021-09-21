package br.com.fiap.challengePluSoft.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.challengePluSoft.model.Address;
import br.com.fiap.challengePluSoft.repository.AddressRepository;

@Controller
public class AddressController {

	private AddressRepository repository;
	@GetMapping("/addreses")
	public ModelAndView index(Address address) {
		ModelAndView modelAndView = new ModelAndView("addreses");
		List<Address> l_addresses =  repository.findAll();
		modelAndView.addObject("addresses",l_addresses);
		return modelAndView;
	}
	
}
