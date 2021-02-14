package com.disqo.note.controller;

import com.disqo.note.response.NoteResponse;
import com.disqo.note.annotation.CurrentUser;
import com.disqo.note.binding.NotePayload;
import com.disqo.note.model.User;
import com.disqo.note.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NotesService notesService;

    @Autowired
    private ProjectionFactory projectionFactory;

    @GetMapping
    public List<NoteResponse> getNotes(@CurrentUser User user){
        return notesService.allNotes(user).stream().map(x->projectionFactory.createProjection(NoteResponse.class, x)).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteResponse creat(@CurrentUser User user, @Valid @RequestBody NotePayload payload){
        return projectionFactory.createProjection(NoteResponse.class, notesService.create(user, payload));
    }

    @GetMapping("/{id}")
    public NoteResponse getNote(@CurrentUser User user, @PathVariable Long id){
        return projectionFactory.createProjection(NoteResponse.class, notesService.getNote(user, id));
    }

    @PutMapping("/{id}")
    public NoteResponse update(@CurrentUser User user, @Valid @RequestBody NotePayload payload, @PathVariable Long id){
        return projectionFactory.createProjection(NoteResponse.class, notesService.update(user, payload, id));
    }
    @DeleteMapping("/{id}")
    public void delete(@CurrentUser User user, @PathVariable Long id){
          notesService.delete(user, id);
    }

}
