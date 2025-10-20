package com.unimib.ilovedevelopers.service;

import androidx.room.Query;

import com.unimib.ilovedevelopers.model.api.response.country.Country;
import com.unimib.ilovedevelopers.model.api.response.country.CountryEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryAPIService {

    @GET("v3.1/all?fields=name,cca2,flags")
    Call<List<CountryEntity>> getAllCountries();
}
