package com.unimib.ilovedevelopers.util;

import android.content.Context;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.model.JobCategory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobCategoryUtil {

    public static final String IT = "it-jobs";
    public static final String SALES = "sales-jobs";

    public static final String HR = "hr-jobs";

    public static final String RESTAURANT = "hospitality-catering-jobs";
    public static final String MARKETING = "pr-advertising-marketing-jobs";

    public static final List<String> JOB_CATEGORIES = Arrays.asList(
            IT, SALES, HR, RESTAURANT, MARKETING
    );

    public static final List<Integer> JOB_CATEGORIES_NAMES = Arrays.asList(
            R.string.job_categories_it, R.string.job_categories_sales, R.string.job_categories_hr, R.string.job_categories_restaurant,
            R.string.job_categories_marketing
    );

    public static ArrayList<JobCategory> generateJobCategoryList(Context context){
        ArrayList<JobCategory> jobCategories = new ArrayList<>();
        for(int i = 0; i < JOB_CATEGORIES.size(); i++){
            jobCategories.add(new JobCategory(context.getString(JOB_CATEGORIES_NAMES.get(i)), JOB_CATEGORIES.get(i)));
        }
        return jobCategories;
    }

}
