package spring.app.ToDoList.service;

import org.springframework.stereotype.Service;
import spring.app.ToDoList.entity.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class NoteService {

    private Map<Long, Note> noteMap = new HashMap<>();
    private Random random = new Random();

    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }

    public Note add(Note note) {
        long id = random.nextLong();
        note.setId(id);
        noteMap.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist");
        }
        noteMap.remove(id);
    }

    public void update(Note note) {
        if (!noteMap.containsKey(note.getId())) {
            throw new IllegalArgumentException("Note with id " + note.getId() + " does not exist");
        }
        noteMap.put(note.getId(), note);
    }

    public Note getById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist");
        }
        return noteMap.get(id);
    }
}
