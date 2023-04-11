package spring.app.ToDoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.app.ToDoList.entity.Note;
import spring.app.ToDoList.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        List<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(notes::add);
        return notes;
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        if (!noteRepository.existsById(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist");
        }
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new IllegalArgumentException("Note with id " + note.getId() + " does not exist");
        }
        noteRepository.save(note);
    }

    public Note getById(long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        } else {
            throw new IllegalArgumentException("Note with id " + id + " does not exist");
        }
    }
}
