package br.com.fiap.challengePluSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.challengePluSoft.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{

}
