package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.models.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) { this.noteMapper = noteMapper;}

    public Note[] getNotes(int userId){
        return noteMapper.getNotes(userId);
    }

    public void addNote(Note note, int userId){
        Note newNote = new Note(0, note.getNoteTitle(), note.getNoteDescription(), userId);
        noteMapper.insert(newNote);
    }

    public void updateNote(Note note) {
        noteMapper.updateNote(note);
    }

    public Note getNote(Integer noteId) {
        return noteMapper.getNote(noteId);
    }

    public void deleteNote(Integer noteId) {
        noteMapper.deleteNote(noteId);
    }



}
