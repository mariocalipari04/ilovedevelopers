package com.unimib.ilovedevelopers.ui.welcome.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.adapter.CountryAdapter;
import com.unimib.ilovedevelopers.model.api.response.country.CountryEntity;
import com.unimib.ilovedevelopers.repository.country.CountryRepository;
import com.unimib.ilovedevelopers.util.ResponseCallBack;
import com.unimib.ilovedevelopers.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

public class PickCountryFragment extends Fragment {

    private final ArrayList<CountryEntity> countryList = new ArrayList<>();
    private CountryAdapter countryAdapter;
    private CountryRepository countryRepository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pick_country, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewCountries);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        countryAdapter = new CountryAdapter(requireContext(), countryList, country -> {
            SharedPreferencesUtil.getInstance(requireContext())
                    .writeStringData("country_of_interest", country.getCca2().toLowerCase());


            Toast.makeText(getContext(),
                            "Country saved: " + country.getName().getCommon(),
                            Toast.LENGTH_SHORT)
                    .show();
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_pickCountryFragment_to_pickJobCategoryFragment);
        });

        recyclerView.setAdapter(countryAdapter);

        setupRepository();

        return view;
    }

    private void setupRepository() {
        countryRepository = new CountryRepository(requireActivity().getApplication(), new ResponseCallBack<CountryEntity>() {
            @Override
            public void onSucccess(List<CountryEntity> countries, long lastUpdate) {
                requireActivity().runOnUiThread(() -> {
                    countryList.clear();
                    countryList.addAll(countries);
                    countryAdapter.notifyDataSetChanged();
                });
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(getContext(), "Errore caricamento paesi: " + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

        new Thread(() -> {
            List<CountryEntity> localCountries = countryRepository.getCountries();
            if (localCountries == null || localCountries.isEmpty()) {
                countryRepository.loadCountries();
            } else {
                requireActivity().runOnUiThread(() -> {
                    countryList.clear();
                    countryList.addAll(localCountries);
                    countryAdapter.notifyDataSetChanged();
                });
            }
        }).start();
    }
}