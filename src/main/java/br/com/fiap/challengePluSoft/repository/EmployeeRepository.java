package br.com.fiap.challengePluSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.challengePluSoft.controller.EmployeeController;

public interface EmployeeRepository extends JpaRepository<EmployeeController, Long>{

}
