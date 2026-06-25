package com.example.myanimelist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 모든 컨트롤러에서 발생하는 예외를 여기서 한 번에 처리함
public class GlobalExceptionHandler {

    @ExceptionHandler(AnimeNotFoundException.class)
    public ResponseEntity<String> handleAnimeNotFound(AnimeNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(DuplicateAnimeException.class)
    public ResponseEntity<String> handleDuplicate(DuplicateAnimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}