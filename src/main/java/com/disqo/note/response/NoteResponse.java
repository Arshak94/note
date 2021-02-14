package com.disqo.note.response;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface NoteResponse {
    public Long getId();
    public String getTitle();
    public String getNote();
    public LocalDateTime getCreatedDate();
    public LocalDateTime getLastUpdateDate();
    @Value("#{target?.getUser()?.getId()}")
    public Long getUserId();
}
