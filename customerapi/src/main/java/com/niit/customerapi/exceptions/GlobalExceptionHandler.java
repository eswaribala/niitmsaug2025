package com.niit.customerapi.exceptions;

import com.niit.customerapi.dtos.ResponseWrapper;
import com.niit.customerapi.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ResponseWrapper> handlerCustomerNotFoundException(CustomerNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseWrapper(ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseWrapper> handleRuntimeException(RuntimeException ex)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseWrapper(ex.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper> handleRuntimeException(Exception ex)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseWrapper(ex.getMessage()));
    }
}
