package com.unimib.ilovedevelopers.util;

import com.unimib.ilovedevelopers.model.api.response.country.CountryEntity;
import com.unimib.ilovedevelopers.model.api.response.job.Job;

import java.util.List;

public interface ResponseCallBack<T> {

    void onSucccess(List<T> data, long timestamp);

    void onFailure(String errorMessage);
}
