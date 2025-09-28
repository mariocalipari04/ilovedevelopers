package com.unimib.ilovedevelopers.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.unimib.ilovedevelopers.model.api.response.Job;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Job.class}, version = 2)
public abstract class JobDatabase extends RoomDatabase {
    public abstract JobDAO JobDao();

    public static volatile JobDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    public static final ExecutorService databaseWriteExcecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static JobDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (JobDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            JobDatabase.class, "SAVED_JOBS_DATABASE").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}

