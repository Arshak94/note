package com.disqo.note.service.impl;

import com.disqo.note.binding.NotePayload;
import com.disqo.note.model.Note;
import com.disqo.note.model.User;
import com.disqo.note.repository.NotesRepository;
import com.disqo.note.service.NotesService;
import com.disqo.note.util.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public List<Note> allNotes(User user) {
        return notesRepository.findAllByUserId(user.getId());
    }

    @Override
    public Note getNote(User user, Long id) {
        return notesRepository.findByIdAndUserId(id, user.getId()).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Note create(User user, NotePayload notePayload) {
        return notesRepository.save(NoteMapper.map(notePayload, user));
    }

    @Override
    public Note update(User user, NotePayload notePayload, Long id) {
        Note note = notesRepository.findByIdAndUserId(id, user.getId()).orElseThrow(EntityNotFoundException::new);
        return NoteMapper.map(note, notePayload, user);
    }

    @Override
    public void delete(User user, Long id) {
        notesRepository.delete(getNote(user, id));
    }
}
