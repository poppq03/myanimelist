package com.example.myanimelist;

public class DuplicateAnimeException extends RuntimeException {
    public DuplicateAnimeException(String title) {
        super("이미 등록된 애니입니다: " + title);
    }
}