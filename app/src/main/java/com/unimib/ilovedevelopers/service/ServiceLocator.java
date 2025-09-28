package com.unimib.ilovedevelopers.service;

import android.app.Application;

import com.unimib.ilovedevelopers.database.JobDatabase;
import com.unimib.ilovedevelopers.util.APIUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.logging.HttpLoggingInterceptor;

public class ServiceLocator {

    private static volatile ServiceLocator INSTANCE = null;

    private ServiceLocator(){

    }

    public static ServiceLocator getInstance(){
        if(INSTANCE == null){
            synchronized (ServiceLocator.class){
                if(INSTANCE == null){
                    INSTANCE = new ServiceLocator();
                }
            }
        }
        return INSTANCE;
    }

    OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                        .build();
                return chain.proceed(request);
            }).build();
    public JobAPIService getJobAPIService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUtil.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(JobAPIService.class);
    }

    public JobDatabase getJobsDB(Application application){
        return JobDatabase.getDatabase(application);
    }
}
