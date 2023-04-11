package spring.app.ToDoList.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.app.ToDoList.entity.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
