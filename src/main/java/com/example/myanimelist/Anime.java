package com.example.myanimelist;

import jakarta.persistence.*;

@Entity //이 클래스는 DB 테이블이라고 알려주는 용도
public class Anime {
    @Id //테이블의 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id를 자동으로 1,2,3 순서대로 생성
    private Long id;

    private String title;
    private String genre;
    private int totalEpisodes;
    private int watchedEpisodes;
    private String status; // 시청중 / 완료 / 보류
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