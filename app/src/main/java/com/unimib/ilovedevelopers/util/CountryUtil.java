package com.unimib.ilovedevelopers.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.model.Country;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryUtil {

    public static final String ITALY = "it";
    public static final String FRANCE = "fr";
    public static final String GERMANY = "de";
    public static final String SPAIN = "es";
    public static final String UNITED_STATES = "us";
    public static final String NEW_ZELAND = "nz";
    public static final String AUSTRALIA = "au";
    public static final String BELGIUM = "be";
    public static final String CANADA = "ca";
    public static final String NETHERLANDS = "nl";
    public static final String SWITZERLAND = "ch";

    public static final List<Integer> COUNTRIES_DRAWABLE = Arrays.asList(
            R.drawable.country_italy, R.drawable.country_united_states
    );

    public static final List<String> COUNTRIES  = Arrays.asList(
            ITALY, FRANCE, BELGIUM, CANADA, GERMANY, NETHERLANDS, AUSTRALIA, SPAIN, NEW_ZELAND, UNITED_STATES, SWITZERLAND
    );

    public static final List<Integer> COUNTRIES_NAME = Arrays.asList(
            R.string.countries_italy, R.string.countries_france, R.string.countries_belgium, R.string.countries_canada,
            R.string.countries_germany, R.string.countries_netherlands, R.string.countries_australia, R.string.countries_spain,
            R.string.countries_new_zeland, R.string.countries_united_states, R.string.countries_switzerland
    );

    public static ArrayList<Country> generateListCountry(Context context){
        ArrayList<Country> countriesList= new ArrayList<>();
        for(int i = 0; i < COUNTRIES.size(); i++){
            countriesList.add(new Country(
                    context.getString(COUNTRIES_NAME.get(i)),
                    COUNTRIES.get(i),
                    context.getDrawable(R.drawable.country_italy)
            ));
        }
        return countriesList;
    }


}
