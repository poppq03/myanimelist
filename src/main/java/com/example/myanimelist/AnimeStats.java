package com.example.myanimelist;

public class AnimeStats {
    private long totalCount;
    private double averageRating;

    public AnimeStats(long totalCount, double averageRating) {
        this.totalCount = totalCount;
        this.averageRating = averageRating;
    }

    public long getTotalCount() { return totalCount; }
    public double getAverageRating() { return averageRating; }
}