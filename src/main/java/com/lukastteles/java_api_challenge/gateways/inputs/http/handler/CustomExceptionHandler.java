package com.lukastteles.java_api_challenge.gateways.inputs.http.handler;

import com.lukastteles.java_api_challenge.exceptions.NotFoundException;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    @ExceptionHandler(NotFoundException.class)
    public HttpEntity<ErrorResponse> handleNotFoundException(final NotFoundException ex) {
        log.debug(ex.getMessage(), ex);
        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(createMessage(ex), responseHeaders, NOT_FOUND);
    }

    @ExceptionHandler({DuplicateKeyException.class})
    public HttpEntity<ErrorResponse> handleConflictException(final RuntimeException ex) {
        log.debug(ex.getMessage(), ex);
        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(responseHeaders, CONFLICT);
    }

    @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class, DataIntegrityViolationException.class})
    public HttpEntity<ErrorResponse> handleIllegalArgumentException(final RuntimeException ex) {
        log.error(ex.getMessage(), ex);
        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(createMessage(ex), responseHeaders, BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<ErrorResponse> handlerValidationException(
            final MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        final BindingResult bindingResult = ex.getBindingResult();
        final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        final ErrorResponse message = processFieldErrors(fieldErrors);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, BAD_REQUEST);
    }

    private ErrorResponse createMessage(final Throwable ex) {
        ErrorResponse message = null;
        if (isNotBlank(ex.getMessage())) {
            message = new ErrorResponse(Collections.singletonList(ex.getMessage()));
        }
        return message;
    }

    private ErrorResponse processFieldErrors(final List<FieldError> fieldErrors) {
        final List<String> errors =
                fieldErrors.stream()
                        .map(error -> String.format("%s: %s", error.getField(), error.getDefaultMessage())).toList();
        return new ErrorResponse(errors);
    }
}
