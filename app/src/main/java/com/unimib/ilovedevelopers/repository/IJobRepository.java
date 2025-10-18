package com.unimib.ilovedevelopers.repository;

public interface IJobRepository {
    void fetchJobs(String country, String category, int page, long lastUpdate);

    void getFavoriteJobs();
}
