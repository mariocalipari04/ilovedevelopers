package com.unimib.ilovedevelopers.service;


import com.unimib.ilovedevelopers.model.api.response.JobSearchResponse;
import com.unimib.ilovedevelopers.util.APIUtil;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JobAPIService {

    // Questo è un metodo, non un campo!
    @GET("jobs/{country}/search/1")
    Call<JobSearchResponse> getJobs(
            @Path("country") String country,
            //@Path("page") int page,
            @Query(APIUtil.QUERY_APP_ID) String appId,
            @Query(APIUtil.QUERY_APP_KEY) String appKey,
            @Query("results_per_page") int resultsPerPage
            //@Query("sort_by") String sortBy
    );
}