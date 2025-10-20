package com.unimib.ilovedevelopers.util;

import android.content.Context;

import com.google.gson.Gson;
import com.unimib.ilovedevelopers.model.api.response.job.JobSearchResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONParserUtil {

    public Context context;

    public JSONParserUtil(Context context){
        this.context = context;
    }
    public JobSearchResponse parseJSONFile(String filename) throws IOException {
        InputStream inputStream = context.getAssets().open(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return new Gson().fromJson(bufferedReader, JobSearchResponse.class);
    }


}
