package com.unimib.ilovedevelopers.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class SharedPreferencesUtil {

    private static SharedPreferencesUtil instance;
    private SharedPreferences prefs;

    public static final String SHARED_PREFERENCES_FILENAME = "com.unimib.ilovedevelopers.preferences";
    public static final String SHARED_PREFERENCES_COUNTRY_OF_INTEREST = "country_of_interest";
    public static final String SHARED_PREFERENCES_CATEGORIES_OF_INTEREST = "categories_of_interest";

    private SharedPreferencesUtil(Context context) {
        prefs = context.getApplicationContext()
                .getSharedPreferences(SHARED_PREFERENCES_FILENAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPreferencesUtil getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesUtil(context);
        }
        return instance;
    }

    public void writeStringData(String key, String value){
        SharedPreferences.Editor editor = prefs.edit(); // prefs è già il file gestito dal singleton
        editor.putString(key, value);
        editor.apply();
    }


    public String readStringData(String key) {
        return prefs.getString(key, null);
    }

    public boolean readBooleanData(String key) {
        return prefs.getBoolean(key, false);
    }

    public int readIntData(String key) {
        return prefs.getInt(key, 0);
    }

}
