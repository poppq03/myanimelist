package com.example.myanimelist;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController //컨트롤러 정의, 응답할 때 자동으로 JSON 형태로 변환
@RequestMapping("/animes")
//animes로 시작하는 URL 요청만 담당한다
public class AnimeController {

    private final AnimeRepository animeRepository;
    private final AnimeService animeService;

    public AnimeController(AnimeRepository animeRepository, AnimeService animeService) {
        this.animeRepository = animeRepository;
        this.animeService = animeService;
    }

    //통계 조회 (* /{id}보다 위에 있어야 한다)
    @GetMapping("/stats")
    public AnimeStats getStats() {
        return animeService.getStats();
    }

    // 전체 조회
    @GetMapping
    public List<Anime> getAll(@RequestParam(required = false) String status) {
        if (status != null) {
            return animeRepository.findByStatus(status);
        }
        return animeRepository.findAll();
    }

    // 단건 조회
    @GetMapping("/{id}")
    public Anime getOne(@PathVariable Long id) {
        return animeRepository.findById(id)
                .orElseThrow(() ->new AnimeNotFoundException(id));
    }

    // 추가
    @PostMapping
    public Anime create(@Valid @RequestBody Anime anime) {
        return animeRepository.save(anime);
    }

    // 수정
    @PutMapping("/{id}")
    public Anime update(@PathVariable Long id, @RequestBody Anime updated) {
        Anime anime = animeRepository.findById(id)
                .orElseThrow(() -> new AnimeNotFoundException(id));
        anime.setTitle(updated.getTitle());
        anime.setGenre(updated.getGenre());
        anime.setTotalEpisodes(updated.getTotalEpisodes());
        anime.setWatchedEpisodes(updated.getWatchedEpisodes());
        anime.setStatus(updated.getStatus());
        anime.setRating(updated.getRating());
        anime.setReview(updated.getReview());
        return animeRepository.save(anime);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        animeRepository.deleteById(id);
    }
}