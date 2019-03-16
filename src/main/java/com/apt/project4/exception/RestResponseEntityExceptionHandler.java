package com.apt.project4.exception;

import com.apt.project4.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> errors = bindingResult.getAllErrors();
        Map<String, String> errorsMap = new HashMap<>();
        errors.forEach(err -> {
            FieldError fieldError = (FieldError) err;
            errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return new ResponseEntity<>(new ErrorResponse(errorsMap), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorResponse> handleKNBadRequestException(
            BadRequestException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InterlalException.class})
    public ResponseEntity<ErrorResponse> handleKNException(InterlalException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
