package com.unimib.ilovedevelopers.ui.home.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.snackbar.Snackbar;
import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.adapter.JobRecyclerAdapter;
import com.unimib.ilovedevelopers.model.api.response.Job;
import com.unimib.ilovedevelopers.repository.IJobRepository;
import com.unimib.ilovedevelopers.repository.JobAPIRepository;
import com.unimib.ilovedevelopers.repository.JobMockRepository;
import com.unimib.ilovedevelopers.util.ResponseCallBack;
import com.unimib.ilovedevelopers.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

public class PreferenceJobFragment extends Fragment implements ResponseCallBack{

    private static final String TAG = PreferenceJobFragment.class.getName();
    private RecyclerView recyclerView;
    private CircularProgressIndicator circularProgressIndicator;
    private IJobRepository jobRepository;

    private JobRecyclerAdapter jobRecyclerAdapter;
    private List<Job> jobList;

    private SharedPreferencesUtil sharedPreferencesUtil;

    public PreferenceJobFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jobList = new ArrayList<>();
        if(requireActivity().getResources().getBoolean(R.bool.debug_mode)){
            jobRepository = new JobMockRepository();
        }else{
            jobRepository = new JobAPIRepository(requireActivity().getApplication(),
                    this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preference_job, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        circularProgressIndicator = view.findViewById(R.id.progressIndicator);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        jobRecyclerAdapter = new JobRecyclerAdapter(R.layout.job_card, jobList, true);
        recyclerView.setAdapter(jobRecyclerAdapter);
        jobRepository.fetchJobs(SharedPreferencesUtil.getInstance(getContext()).readStringData(SharedPreferencesUtil.SHARED_PREFERENCES_COUNTRY_OF_INTEREST),
                SharedPreferencesUtil.getInstance(getContext()).readStringData(SharedPreferencesUtil.SHARED_PREFERENCES_CATEGORIES_OF_INTEREST),1,100);
        return view;
    }

    @Override
    public void onSucccess(List<Job> jobList, long lastUpdate) {
        this.jobList.clear();
        this.jobList.addAll(jobList);
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                jobRecyclerAdapter.notifyDataSetChanged();
                recyclerView.setVisibility(View.VISIBLE);
                circularProgressIndicator.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onFailure(String errorMessage) {
        Snackbar.make(recyclerView, errorMessage, Snackbar.LENGTH_LONG).show();
    }
}