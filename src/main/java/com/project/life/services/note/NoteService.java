package com.project.life.services.note;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.life.models.note.Note;
import com.project.life.repositories.note.NoteRepository;


@Service
public class NoteService {
	
	private final NoteRepository noteRepository;
	
	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	public List<Note> getAll() {
		return noteRepository.findAll();
	}

	public Note addNote(Note n) {
		return noteRepository.save(n);
	}

	public Note getNoteById(Long id) {
		Optional<Note> n = noteRepository.findById(id);
		if (n.isPresent()) {
			return n.get();
		} else {
			return null;
		}
	}

	public Note update(Note n) {
		return noteRepository.save(n);		
	}
}
