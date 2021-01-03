package com.project.life.repositories.note;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.life.models.note.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{
	List<Note> findAll();
}
