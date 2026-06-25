package com.example.myanimelist;

import org.springframework.stereotype.Service;
import java.util.List;

@Service // 이 클래스는 비즈니스 로직을 담당한다고 Spring에게 알려줌
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public AnimeStats getStats() {
        List<Anime> animes = animeRepository.findAll();

        long totalCount = animes.size();

        double averageRating = animes.stream()
                .mapToDouble(Anime::getRating)
                .average()
                .orElse(0.0); // 애니가 하나도 없으면 0.0
        // 애니 목록 -> 평점 뽑기 -> 평균 계산 흐름

        return new AnimeStats(totalCount, averageRating);
    }
}