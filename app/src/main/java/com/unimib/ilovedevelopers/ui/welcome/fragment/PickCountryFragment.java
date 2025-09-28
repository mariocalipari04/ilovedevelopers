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
import com.unimib.ilovedevelopers.adapter.CountryAdapter;
import com.unimib.ilovedevelopers.util.CountryUtil;

public class PickCountryFragment extends Fragment {

    private static final String TAG = PickCountryFragment.class.getName();

    public PickCountryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pick_country, container, false);

        CountryAdapter countryAdapter = new CountryAdapter(getContext(),
                R.layout.country_card,
                CountryUtil.generateListCountry(getContext()));
        GridView gridView = view.findViewById(R.id.GridViewCountry);
        gridView.setAdapter(countryAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}