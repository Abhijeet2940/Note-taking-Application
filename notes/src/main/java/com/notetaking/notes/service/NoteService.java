package com.notetaking.notes.service;

import com.notetaking.notes.entity.Note;
import com.notetaking.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
     private final NoteRepository noteRepository;

     public NoteService(NoteRepository noteRepository){
         this.noteRepository= noteRepository;
     }

     public List<Note> getAllNote(){
         return noteRepository.findAll();
     }
     public Note CreateNote(Note note){
         return noteRepository.save(note);
     }
      public void deleteNote(Long id){
         noteRepository.deleteById(id);
      }

      public Note getNodeByID(Long id){
         return noteRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Note not found"));
      }
      public Note UpdateNote(Long id, Note updatedNote){
         Note note =getNodeByID(id);
         note.setTitle(updatedNote.getTitle());
         note.setDescription(updatedNote.getDescription());
         return noteRepository.save(note);
      }
}
