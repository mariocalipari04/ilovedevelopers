package com.unimib.ilovedevelopers.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.model.JobCategory;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<JobCategory> {

    private int layout;
    private ArrayList<JobCategory> jobCategories;
    public CategoryAdapter(@NonNull Context context, int layout, ArrayList<JobCategory> jobCategories) {
        super(context, layout, jobCategories);
        this.layout = layout;
        this.jobCategories = jobCategories;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(layout, parent, false);

        TextView title = convertView.findViewById(R.id.category_text);

        title.setText(jobCategories.get(position).getName());

        return convertView;
    }
}
