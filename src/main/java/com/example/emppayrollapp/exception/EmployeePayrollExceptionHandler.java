package com.example.emppayrollapp.exception;


import com.example.emppayrollapp.DTO.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {

    private static final String message = "Exception while processing REST Request";
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(
                                        HttpMessageNotReadableException exception){
        log.error("Invalid Date Format", exception);
        ResponseDTO responseDTO = new ResponseDTO(message,
                "Should Have Date In The Format dd MM yyyy");
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleIdException(EmployeePayrollException exception) {
        return new ResponseEntity<>(new ResponseDTO("Exceptions while processing REST request",
                exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException
            (MethodArgumentNotValidException exception){
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        List<String> errorMessages = allErrors.stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return new ResponseEntity<>(new ResponseDTO("Validation Error",errorMessages),
                HttpStatus.BAD_REQUEST);
    }
}
