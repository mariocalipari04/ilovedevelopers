package com.unimib.ilovedevelopers.database.country;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.unimib.ilovedevelopers.model.api.response.country.CountryEntity;
import com.unimib.ilovedevelopers.util.converter.Converter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CountryEntity.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class CountryDatabase extends RoomDatabase {

    public abstract CountryDAO countryDao();

    public static volatile CountryDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    public static final ExecutorService databaseWriteExcecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static CountryDatabase getDatabase(final Context context) {
        if(INSTANCE == null){
            synchronized (CountryDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CountryDatabase.class, "SAVED_COUNTRIES_DATABASE").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }


}
