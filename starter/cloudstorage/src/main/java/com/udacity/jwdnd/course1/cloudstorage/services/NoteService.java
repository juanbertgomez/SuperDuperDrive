package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.models.Note;

public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) { this.noteMapper = noteMapper;}

    public void addNote(String title, String description, int userId){
        Note note = new Note(0, title, description, userId);
        noteMapper.insert(note);
    }

    public Note getNote(Integer noteId) {
        return noteMapper.getNote(noteId);
    }

    public void deleteNote(Integer noteId) {
        noteMapper.deleteNote(noteId);
    }

    public void updateNote(Integer noteId, String title, String description) {
        noteMapper.updateNote(noteId, title, description);
    }

}
