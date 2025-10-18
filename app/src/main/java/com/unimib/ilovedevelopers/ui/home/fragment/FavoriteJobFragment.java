package com.unimib.ilovedevelopers.ui.home.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.adapter.JobRecyclerAdapter;
import com.unimib.ilovedevelopers.database.JobDatabase;
import com.unimib.ilovedevelopers.model.api.response.Job;
import com.unimib.ilovedevelopers.model.api.response.JobSearchResponse;
import com.unimib.ilovedevelopers.util.JSONParserUtil;

import java.io.IOException;
import java.util.List;

public class FavoriteJobFragment extends Fragment {


    public FavoriteJobFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite_job, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        List<Job> jobList = JobDatabase.getDatabase(getContext()).JobDao().getLiked();

        JobRecyclerAdapter jobRecyclerAdapter = new JobRecyclerAdapter(R.layout.job_card, jobList, false);
        recyclerView.setAdapter(jobRecyclerAdapter);

        return view;
    }
}