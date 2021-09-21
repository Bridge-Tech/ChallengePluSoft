package br.com.fiap.challengePluSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.challengePluSoft.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
