package com.unimib.ilovedevelopers.ui.welcome.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.adapter.CategoryAdapter;
import com.unimib.ilovedevelopers.util.JobCategoryUtil;


public class PickJobCategoryFragment extends Fragment {

    public PickJobCategoryFragment() {
        // Required empty public constructor
    }

    public static PickJobCategoryFragment newInstance(String param1, String param2) {
        PickJobCategoryFragment fragment = new PickJobCategoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pick_job_category, container, false);

        GridView gridView = view.findViewById(R.id.GridViewCategory);

        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), R.layout.category_card,
                JobCategoryUtil.generateJobCategoryList(getContext()));

        gridView.setAdapter(categoryAdapter);
        return view;
    }

    //logica di business
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}