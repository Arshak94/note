package com.disqo.note.service;

import com.disqo.note.binding.NotePayload;
import com.disqo.note.model.Note;
import com.disqo.note.model.User;

import java.util.List;

public interface NotesService {
    List<Note> allNotes(User user);
    Note getNote(User user, Long id);
    Note create(User user, NotePayload notePayload);
    Note update(User user, NotePayload notePayload, Long id);
    void delete(User user, Long id);
}
