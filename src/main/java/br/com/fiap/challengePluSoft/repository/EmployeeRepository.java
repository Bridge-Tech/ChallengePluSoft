package br.com.fiap.challengePluSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.challengePluSoft.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
