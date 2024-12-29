package com.dictionary.region.customExceptionAdviceHandler;

import com.dictionary.region.exception.RegionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RegionExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError handleRegionNotFound(RegionNotFoundException e) {
        return new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());
    }
}
