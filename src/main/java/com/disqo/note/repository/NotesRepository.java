package com.disqo.note.repository;

import com.disqo.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

    public List<Note> findAllByUserId(Long userId);
    public Optional<Note> findByIdAndUserId(Long id,Long userId);
}
