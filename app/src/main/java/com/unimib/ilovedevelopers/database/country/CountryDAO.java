package com.unimib.ilovedevelopers.database.country;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.unimib.ilovedevelopers.model.api.response.country.CountryEntity;

import java.util.List;

@Dao
public interface CountryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CountryEntity> countries);

    @Query("SELECT * FROM countries ORDER BY name ASC")
    List<CountryEntity> getAllCountries();

    @Query("SELECT * FROM countries WHERE code = :code LIMIT 1")
    CountryEntity getCountryByCode(String code);

    @Query("SELECT * FROM countries WHERE name LIKE '%' || :query || '%' ORDER BY name ASC")
    List<CountryEntity> searchCountries(String query);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertCountryList(List<CountryEntity> countryList);
}
