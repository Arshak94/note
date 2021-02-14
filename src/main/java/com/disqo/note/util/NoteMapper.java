package com.disqo.note.util;

import com.disqo.note.binding.NotePayload;
import com.disqo.note.model.Note;
import com.disqo.note.model.User;

import java.time.LocalDateTime;

public class NoteMapper {

    public static Note map(NotePayload notePayload, User user){
        Note note = new Note();
        note.setTitle(notePayload.getTitle());
        note.setNote(notePayload.getNote());
        note.setUser(user);
        return note;
    }

    public static Note map(Note note, NotePayload notePayload, User user){
        note.setTitle(notePayload.getTitle());
        note.setNote(notePayload.getNote());
        note.setLastUpdateDate(LocalDateTime.now());
        note.setUser(user);
        return note;
    }
}
