package br.com.fiap.challengePluSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.challengePluSoft.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
