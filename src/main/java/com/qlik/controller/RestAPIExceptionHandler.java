package com.qlik.controller;


import com.qlik.dto.ValidationErrorDTO;
import com.qlik.exceptions.InvalidStringInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestAPIExceptionHandler {

    private MessageSource messageSource;

    @Autowired
    public RestAPIExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(InvalidStringInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity processValidationError(InvalidStringInputException ex) {
        ResponseEntity responseEntity = new ResponseEntity();

    }
}