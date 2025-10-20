package com.unimib.ilovedevelopers.repository.job;

public interface IJobRepository {
    void fetchJobs(String country, String category, int page, long lastUpdate);

    void getFavoriteJobs();
}
