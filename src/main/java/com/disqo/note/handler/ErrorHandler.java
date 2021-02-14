package com.disqo.note.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.util.InvalidMimeTypeException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler({MultipartException.class, InvalidMimeTypeException.class, IllegalArgumentException.class,
            MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class,
            JsonMappingException.class, JsonParseException.class, InvalidRequestException.class,
            IllegalStateException.class})
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleBadRequest(Exception ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleIntegrityViolation(DataIntegrityViolationException ex) {
        return new ErrorResponse(ofNullable(ex.getRootCause()).map(Throwable::getMessage).orElse(ex.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        if (!bindingResult.getGlobalErrors().isEmpty()) {
            final String globalErrors = bindingResult.getGlobalErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(joining(", "));
            return new ErrorResponse(globalErrors);
        }
        final Set<FieldError> fieldErrors = bindingResult.getFieldErrors().stream()
                .map(fieldError -> new FieldError(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(toSet());
        return new ErrorResponse(fieldErrors);
    }

    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleConstraintViolation(ConstraintViolationException ex) {
        return new ErrorResponse(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(joining("; ")));
    }

    @ExceptionHandler
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handleNoSuchElement(EntityNotFoundException ex) {
        return new ErrorResponse(NOT_FOUND, ofNullable(ex.getMessage()).orElse("Resource Not Found."));
    }
}
