package br.com.fiap.challengePluSoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.challengePluSoft.model.Employee;
import br.com.fiap.challengePluSoft.repository.EmployeeRepository;


@Service
public class AuthenticationService implements UserDetailsService{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> employee = repository.findByUser(username);
		if(employee.isEmpty()) 
			throw new UsernameNotFoundException("Employee not found");
		return employee.get();

	}
}		
