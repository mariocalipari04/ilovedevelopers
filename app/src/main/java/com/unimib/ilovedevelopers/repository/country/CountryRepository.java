package com.unimib.ilovedevelopers.repository.country;

import android.app.Application;
import android.util.Log;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.database.country.CountryDAO;
import com.unimib.ilovedevelopers.database.country.CountryDatabase;
import com.unimib.ilovedevelopers.model.api.response.country.CountryEntity;
import com.unimib.ilovedevelopers.service.CountryAPIService;
import com.unimib.ilovedevelopers.service.ServiceLocator;
import com.unimib.ilovedevelopers.util.ResponseCallBack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryRepository implements ICountryRepository {

    private static final String TAG = CountryRepository.class.getName();

    private final CountryDAO countryDao;
    private final Application application;
    private final CountryAPIService countryAPIService;
    private final ExecutorService executorService;

    private final ResponseCallBack<CountryEntity> responseCallBack;

    public CountryRepository(Application application, ResponseCallBack<CountryEntity> responseCallBack) {
        this.application = application;
        this.responseCallBack = responseCallBack;
        this.countryAPIService = ServiceLocator.getInstance().getCountryAPIService();
        CountryDatabase countryDatabase = ServiceLocator.getInstance().getCountryDB(application);
        this.countryDao = countryDatabase.countryDao();
        executorService = CountryDatabase.databaseWriteExcecutor;
    }

    @Override
    public void loadCountries() {
        Call<List<CountryEntity>> call = countryAPIService.getAllCountries(); // usa direttamente CountryEntity

        call.enqueue(new Callback<List<CountryEntity>>() {
            @Override
            public void onResponse(Call<List<CountryEntity>> call, Response<List<CountryEntity>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<CountryEntity> countryList = response.body();
                    if (countryList != null) {
                        for (CountryEntity c : countryList) {
                            Log.d(TAG, "Received country - code: " + c.getCode() + ", cca2: " + c.getCca2());
                        }
                    } else {
                        Log.e(TAG, "Response body è null!");
                    }
                    saveDataInDatabase(countryList);
                } else {
                    responseCallBack.onFailure(application.getString(R.string.error_message));
                }
            }

            @Override
            public void onFailure(Call<List<CountryEntity>> call, Throwable t) {
                Log.e(TAG, "Errore nella chiamata API: ", t);
                responseCallBack.onFailure(application.getString(R.string.error_message));
            }
        });
    }

    private void saveDataInDatabase(List<CountryEntity> countryList) {
        executorService.execute(() -> {
            List<CountryEntity> validCountries = new ArrayList<>();
            for (CountryEntity country : countryList) {
                // Usa cca2 come code
                if (country.getCca2() != null && !country.getCca2().isEmpty()) {
                    country.setCode(country.getCca2());  // <-- qui assegni code
                    validCountries.add(country);
                    Log.d(TAG, "Inserting country: " + country.getCode());
                }
            }

            // Inserimento su database
            countryDao.insertCountryList(validCountries);

            // Callback
            responseCallBack.onSucccess(validCountries, System.currentTimeMillis());
        });
    }

    public List<CountryEntity> getCountries() {
        return countryDao.getAllCountries();
    }

    public List<CountryEntity> searchCountries(String query) {
        return countryDao.searchCountries(query);
    }

    public void saveCountries(List<CountryEntity> countries) {
        executorService.execute(() -> countryDao.insertCountryList(countries));
    }
}