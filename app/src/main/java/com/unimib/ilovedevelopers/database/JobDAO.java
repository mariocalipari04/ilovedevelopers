package com.unimib.ilovedevelopers.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.unimib.ilovedevelopers.model.api.response.Job;

import java.util.List;

@Dao
public interface JobDAO {
    @Query("SELECT * FROM Job ORDER BY created DESC")
    List<Job> getAll();

    @Query("SELECT * FROM Job WHERE liked = 1")
    List<Job> getLiked();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Job... jobs);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertJobList(List<Job> jobList);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Job job);

    @Update
    void updateJob(Job job);

    @Delete
    void delete(Job job);

    @Query("DELETE from Job")
    void deleteAll();

}