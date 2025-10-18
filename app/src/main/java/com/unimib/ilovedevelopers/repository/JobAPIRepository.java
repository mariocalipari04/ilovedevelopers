package com.unimib.ilovedevelopers.repository;

import android.app.Application;
import android.util.Log;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.database.JobDAO;
import com.unimib.ilovedevelopers.database.JobDatabase;
import com.unimib.ilovedevelopers.model.api.response.Job;
import com.unimib.ilovedevelopers.model.api.response.JobSearchResponse;
import com.unimib.ilovedevelopers.service.JobAPIService;
import com.unimib.ilovedevelopers.service.ServiceLocator;
import com.unimib.ilovedevelopers.util.ResponseCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobAPIRepository implements IJobRepository {

    private static final String TAG = JobAPIRepository.class.getName();
    private final Application application;
    private final ResponseCallBack callBack;
    private final JobDAO jobDAO;
    private final JobAPIService jobAPIService;
    public JobAPIRepository(Application application, ResponseCallBack callBack){
        this.application = application;
        this.callBack = callBack;
        this.jobAPIService = ServiceLocator.getInstance().getJobAPIService();
        JobDatabase jobDatabase = ServiceLocator.getInstance().getJobsDB(application);
        this.jobDAO = jobDatabase.JobDao();
    }
    @Override
    public void fetchJobs(String country, String category, int page, long lastUpdate) {
        long currentTime = System.currentTimeMillis();
        if(true){
            Call<JobSearchResponse> jobSearchResponseCall = jobAPIService.getJobs(country, category,
                    application.getString(R.string.jobapi_id), application.getString(R.string.jobapi_key),50, "date");
            jobSearchResponseCall.enqueue(new Callback<JobSearchResponse>() {
                @Override
                public void onResponse(Call<JobSearchResponse> call, Response<JobSearchResponse> response) {

                    Log.i(TAG, "Response code: " + response.code());
                    Log.i(TAG, "Body: " + response.body());
                    if(response.body() != null && response.isSuccessful() /*&& !response.body().ge()
                            .equals("error")*/){
                        Log.i(TAG, response.toString()+ "AAAAAAAAAA");
                        List<Job> jobList = response.body().getResults();
                        //Job.filterJobs(jobList);
                        saveDataInDatabase(jobList);
                    }else{
                        callBack.onFailure(application.getString(R.string.error_message));
                    }
                }

                @Override
                public void onFailure(Call<JobSearchResponse> call, Throwable t) {
                    readDataFromDatabase(lastUpdate);
                }
            });
        }else{
            readDataFromDatabase(lastUpdate);
        }
    }

    private void saveDataInDatabase(List<Job> jobList){
        JobDatabase.databaseWriteExcecutor.execute(()->{
            List<Job> allJobs = jobDAO.getAll();
            for(Job job : allJobs){
                if(jobList.contains(job)){
                    jobList.set(jobList.indexOf(job), job);
                }
            }
            List<Long> insertedJobIds = jobDAO.insertJobList(jobList);
            for(int i = 0; i < jobList.size(); i++){
                jobList.get(i).setId(String.valueOf(insertedJobIds.get(i)));
            }
            callBack.onSucccess(jobList, System.currentTimeMillis());
        });
    }

    private void readDataFromDatabase(long lastUpdate){
        JobDatabase.databaseWriteExcecutor.execute(()->{
            callBack.onSucccess(jobDAO.getAll(), lastUpdate);
        });
    }


    @Override
    public void getFavoriteJobs() {

    }
}
