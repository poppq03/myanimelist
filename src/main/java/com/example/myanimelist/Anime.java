package com.example.myanimelist;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity //이 클래스는 DB 테이블이라고 알려주는 용도
public class Anime {
    @Id //테이블의 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id를 자동으로 1,2,3 순서대로 생성
    private Long id;

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    private String genre;

    @Min(value = 0, message = "전체 화수는 0 이상이어야 합니다.")
    private int totalEpisodes;

    @Min(value = 0, message = "시청 화수는 0 이상이어야 합니다.")
    private int watchedEpisodes;

    private String status; // 시청중 / 완료 / 보류

    @Min(value = 0, message = "평점은 0 이상이어야 합니다.")
    @Max(value = 5, message = "평점은 5 이하여야 합니다.")
    private double rating;

    private String review;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getTotalEpisodes() { return totalEpisodes; }
    public void setTotalEpisodes(int totalEpisodes) { this.totalEpisodes = totalEpisodes; }
    public int getWatchedEpisodes() { return watchedEpisodes; }
    public void setWatchedEpisodes(int watchedEpisodes) { this.watchedEpisodes = watchedEpisodes; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }
}