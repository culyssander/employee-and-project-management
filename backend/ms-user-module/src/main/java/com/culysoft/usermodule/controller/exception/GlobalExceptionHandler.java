package com.culysoft.usermodule.controller.exception;

import com.culysoft.usermodule.exception.UserAlreadyExistsException;
import com.culysoft.usermodule.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;


    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> handlerNegocioException(UserAlreadyExistsException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Problema problema = getProblema(status.value(), ex.getMessage(), null);

        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handlerObjectNotFoundException(UserNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        Problema problema = getProblema(status.value(), ex.getMessage(), null);

        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Campo> camposDeErros = new ArrayList<Campo>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            camposDeErros.add(new Campo(nome, mensagem));
        }

        Problema problema = getProblema(
                status.value(),
                "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente",
                camposDeErros);

        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }
    

    private Problema getProblema(Integer status, String titulo, List<Campo> campos) {
        return new Problema(status, OffsetDateTime.now(), titulo, campos);
    }
}
