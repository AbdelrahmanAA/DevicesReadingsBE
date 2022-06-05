package com.example.task.exception;

import com.example.task.util.APIResponseGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ Exception.class})
    public ResponseEntity<?> handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.ok(APIResponseGenerator.generateFailureResponse());
    }

}
