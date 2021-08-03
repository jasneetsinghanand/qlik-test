package com.qlik.exceptions;

public class InvalidStringInputException extends RuntimeException {

    public InvalidStringInputException(String str) {
        super(String.format("String %s given in the input is invalid", str));
    }
}
