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
import com.unimib.ilovedevelopers.model.api.response.Job;
import com.unimib.ilovedevelopers.model.api.response.JobSearchResponse;
import com.unimib.ilovedevelopers.util.JSONParserUtil;

import java.io.IOException;
import java.util.List;

public class StatisticsJobFragment extends Fragment {

    public static final String TAG = StatisticsJobFragment.class.getName();

    public StatisticsJobFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics_job, container, false);

        return view;
    }
}