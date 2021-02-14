package com.disqo.note.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NotePayload {

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    @Size(max = 1000)
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
