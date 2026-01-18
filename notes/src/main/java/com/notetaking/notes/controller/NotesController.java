package com.notetaking.notes.controller;

import com.notetaking.notes.entity.Note;
import com.notetaking.notes.service.NoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    private final NoteService noteService;

    public NotesController(NoteService noteService){
        this.noteService= noteService;
    }

    @PostMapping
    public Note createNote(@RequestBody Note note){
        return noteService.CreateNote(note);
    }
    @GetMapping("/id")
    public Note getNote(@PathVariable Long id){
        return noteService.getNodeByID(id);
    }
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note){
        return noteService.UpdateNote(id,note);
    }



    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable Long id){
        noteService.deleteNote(id);
    }
}
