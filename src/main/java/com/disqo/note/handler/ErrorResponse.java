package com.disqo.note.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponse {
    private HttpStatus code;
    private String message;
    private Set<FieldError> fieldErrors;

    ErrorResponse(String message) {
        this(HttpStatus.BAD_REQUEST, message);
    }

    ErrorResponse(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorResponse(Set<FieldError> fieldErrors) {
        this.code = HttpStatus.BAD_REQUEST;
        this.message = "Payload Validation Failed";
        this.fieldErrors = fieldErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Set<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Set<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public String getCode() {
        return String.format("%s", code.value());
    }
}
