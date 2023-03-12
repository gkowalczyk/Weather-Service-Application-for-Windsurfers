package com.gkowalczyk.weatherserviceforwindsurfers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(WeatherMapNotFoundException.class)
    public ResponseEntity<Object> handleFamilyNotFoundException(WeatherMapNotFoundException exception) {
        return new ResponseEntity<>("WeatherForecast was not finding, stay in home please", HttpStatus.BAD_REQUEST);
    }
}