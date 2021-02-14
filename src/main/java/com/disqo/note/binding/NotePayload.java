package com.disqo.note.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NotePayload {

    @NotBlank(message = "Title can not be a blank")
    @Size(max = 50, message = "Title can not be max 50 character")
    private String title;

    @NotBlank(message = "Title can not be a blank")
    @Size(max = 1000, message = "Note can not be max 1000 character")
    private String note;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
