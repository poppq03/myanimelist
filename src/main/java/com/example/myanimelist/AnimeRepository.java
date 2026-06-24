package com.example.myanimelist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
} //JpaRepository 상속 받는 인터페이스
//JpaRepository 상속 받으면 DB 기능 사용 가능
//Anime는 테이블을 다루고, id 타입은 Long