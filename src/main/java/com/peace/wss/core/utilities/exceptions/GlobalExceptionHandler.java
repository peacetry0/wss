package com.peace.wss.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiException handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        ValidationApiException validationApiException = new ValidationApiException();
        validationApiException.setStatus(404);
        validationApiException.setMessage("Validation exception");
        validationApiException.setValidationErrors(new HashMap<String,String>());

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationApiException.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        return validationApiException ;

    }


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiException handleUserNotFoundException(UserNotFoundException userNotFoundException){
        ApiException apiException = new ApiException();
        apiException.setStatus(404);
        apiException.setMessage(userNotFoundException.getMessage());
        return apiException ;
    }

    @ExceptionHandler(InvalidUserNameException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiException handleInvalidUserNameException(InvalidUserNameException invalidUserNameException){
        ApiException apiException = new ApiException();
        apiException.setStatus(404);
        apiException.setMessage(invalidUserNameException.getMessage());

        return apiException ;

    }
}
