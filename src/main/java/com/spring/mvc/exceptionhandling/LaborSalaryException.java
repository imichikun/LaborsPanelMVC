package com.spring.mvc.exceptionhandling;

public class LaborSalaryException extends RuntimeException{
    public LaborSalaryException(String message) {
        super(message);
    }
}
