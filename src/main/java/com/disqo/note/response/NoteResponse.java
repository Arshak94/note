package com.disqo.note.response;

import org.springframework.beans.factory.annotation.Value;

public interface NoteResponse {
    public Long getId();
    public String getTitle();
    public String getNote();
    public String getCreatedDate();
    @Value("#{target?.getUser()?.getId()}")
    public Long getUserId();
}
