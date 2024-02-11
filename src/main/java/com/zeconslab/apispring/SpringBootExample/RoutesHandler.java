package com.zeconslab.apispring.SpringBootExample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RoutesHandler {
    private final Logger log = LogManager.getLogger(RoutesHandler.class);
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String nullPointerException(NullPointerException exception) {
        log.error("Error interno del servidor [{}]" , exception.getMessage());
        return "Error interno, Contacta a soporte";
    }
}
