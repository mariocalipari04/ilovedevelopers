package com.unimib.ilovedevelopers.repository;

public interface IJobRepository {
    void fetchJobs(String country, int page, long lastUpdate);

    void getFavoriteJobs();
}
