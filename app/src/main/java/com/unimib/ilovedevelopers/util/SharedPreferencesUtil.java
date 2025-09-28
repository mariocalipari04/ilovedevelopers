package com.unimib.ilovedevelopers.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class SharedPreferencesUtil {

    public static final String SHARED_PREFERENCES_FILENAME = "com.unimib.ilovedevelopers.preferences";
    public static final String SHARED_PREFERENCES_COUNTRY_OF_INTEREST = "country_of_interest";
    public static final String SHARED_PREFERENCES_CATEGORIES_OF_INTEREST = "categories_of_interest";
    private final Context context;

    public SharedPreferencesUtil(Context context){
        this.context = context;
    }

    public void writeStringData(String sharedPreferencesFileName, String key, String value){
        SharedPreferences sharePref = context.getSharedPreferences(sharedPreferencesFileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void writeStringSetData(String sharedPreferencesFileName, String key, Set<String> value){
        SharedPreferences sharePref = context.getSharedPreferences(sharedPreferencesFileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    public String readStringData(String sharedPreferencesFileName, String key){
        SharedPreferences sharePref = context.getSharedPreferences(sharedPreferencesFileName,
                Context.MODE_PRIVATE);
        return sharePref.getString(key, null);
    }

    public Set<String> readStringSetData(String sharedPreferencesFileName, String key) {
        SharedPreferences sharePref = context.getSharedPreferences(sharedPreferencesFileName,
                Context.MODE_PRIVATE);
        return sharePref.getStringSet(key, null);
    }
}
