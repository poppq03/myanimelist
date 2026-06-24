package com.example.myanimelist;

public class AnimeNotFoundException extends RuntimeException {
    public AnimeNotFoundException(Long id) {
        super("해당 id의 애니메이션을 찾을 수 없습니다: " + id);
    }
}