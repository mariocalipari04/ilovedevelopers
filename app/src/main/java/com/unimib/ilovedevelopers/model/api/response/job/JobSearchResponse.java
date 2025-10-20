package com.unimib.ilovedevelopers.model.api.response.job;

import java.util.List;

public class JobSearchResponse {
    private double mean;
    private String __CLASS__;
    private int count;
    private List<Job> results;

    // Getters e Setters
    public double getMean() { return mean; }
    public void setMean(double mean) { this.mean = mean; }

    public String get__CLASS__() { return __CLASS__; }
    public void set__CLASS__(String __CLASS__) { this.__CLASS__ = __CLASS__; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public List<Job> getResults() { return results; }

    public int getTotalResults(){
        return results.size();
    }
    public void setResults(List<Job> results) { this.results = results; }
}