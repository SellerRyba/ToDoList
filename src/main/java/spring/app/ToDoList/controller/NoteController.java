package spring.app.ToDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.app.ToDoList.entity.Note;
import spring.app.ToDoList.service.NoteService;
import java.util.List;

@Controller
public class NoteController {
    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/note/list")
    public ModelAndView showNoteList() {
        ModelAndView result = new ModelAndView("note/list");
        List<Note> notes = noteService.listAll();
        result.addObject("notes", notes);
        return result;
    }

    @GetMapping("/note/edit")
    public ModelAndView showNoteForm(@RequestParam(name = "id", required = false) Long id) {
        ModelAndView result = new ModelAndView("note/edit");
        Note note = new Note();
        if (id != null) {
            note = noteService.getById(id);
        }
        result.addObject("note", note);
        return result;
    }

    @PostMapping("/note/edit")
    public String saveOrUpdateNote(@ModelAttribute("note") Note note) {
        if (note.getId() == null) {
            noteService.add(note);
        } else {
            noteService.update(note);
        }
        return "redirect:/note/list";
    }



    @PostMapping("/note/delete")
    public ModelAndView deleteNoteById(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }
}
