package com.POS.SB.backend.advisor;

import com.POS.SB.backend.exception.NotFoundException;
import com.POS.SB.backend.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error Coming",e.getMessage()),
                HttpStatus.NOT_FOUND

        );
    }
}
