package com.unimib.ilovedevelopers.util;

import com.unimib.ilovedevelopers.model.api.response.Job;

import java.util.List;

public interface ResponseCallBack {

    void onSucccess(List<Job> jobList, long lastUpdate);
    void onFailure(String errorMessage);
}
