package com.spring.mvc.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class laborGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<LaborIncorrectData> exceptionHandler(LaborSalaryException laborSalaryException){
        LaborIncorrectData laborIncorrectData = new LaborIncorrectData();
        laborIncorrectData.setInfo(laborSalaryException.getMessage());
        return new ResponseEntity<>(laborIncorrectData, HttpStatus.NOT_FOUND);
    }


}