package com.unimib.ilovedevelopers.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;

import com.google.android.material.card.MaterialCardView;
import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.model.Country;
import com.unimib.ilovedevelopers.util.SharedPreferencesUtil;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {

    private int layout;
    private ArrayList<Country> countriesList;
    public CountryAdapter(@NonNull Context context, @NonNull int layout, @NonNull ArrayList<Country> countriesList) {
        super(context, layout, countriesList);
        this.layout = layout;
        this.countriesList = countriesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(layout, parent, false);

        TextView title = convertView.findViewById(R.id.textView);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        title.setText(countriesList.get(position).getName());
        imageView.setImageDrawable(countriesList.get(position).getImage());

         convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil(getContext());
                sharedPreferencesUtil.writeStringData(SharedPreferencesUtil.SHARED_PREFERENCES_FILENAME,
                        SharedPreferencesUtil.SHARED_PREFERENCES_COUNTRY_OF_INTEREST,
                        countriesList.get(position).getCode());
                Navigation.findNavController(v).navigate(R.id.action_pickCountryFragment_to_pickJobCategoryFragment);
            }
        });

        return convertView;
    }
}
