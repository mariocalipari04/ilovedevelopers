package com.unimib.ilovedevelopers.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.database.job.JobDatabase;
import com.unimib.ilovedevelopers.model.api.response.job.Job;

import java.util.List;

public class JobRecyclerAdapter extends RecyclerView.Adapter<JobRecyclerAdapter.ViewHolder> {

    private int layout;
    private List<Job> jobList;

    private boolean heartVisible;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTitle;
        private final TextView textViewCompany;
        private final TextView textViewCreatedAt;
        private final CheckBox favoriteCheckbox;

        public ViewHolder(View view) {
            super(view);
            textViewCreatedAt= view.findViewById(R.id.createdAt);
            textViewTitle = view.findViewById(R.id.job_title);
            textViewCompany = view.findViewById(R.id.job_company);
            favoriteCheckbox = view.findViewById(R.id.favoriteButton);
        }

        public TextView getTextViewCreatedAt() {
            return textViewCreatedAt;
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }

        public TextView getTextViewCompany() {
            return textViewCompany;
        }

        public CheckBox getFavoriteCheckbox() {
            return favoriteCheckbox;
        }
    }
    public JobRecyclerAdapter(int layout, List<Job> jobList, boolean heartVisible) {
        this.layout = layout;
        this.jobList = jobList;
        this.heartVisible = heartVisible;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getTextViewCreatedAt().setText(jobList.get(position).getCreated());
        viewHolder.getTextViewCompany().setText(jobList.get(position).getCompany().getDisplay_name());
        viewHolder.getTextViewTitle().setText(jobList.get(position).getTitle());
        viewHolder.getFavoriteCheckbox().setChecked(jobList.get(position).getLiked());

        viewHolder.getFavoriteCheckbox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                Job currentJob = jobList.get(viewHolder.getBindingAdapterPosition());

                currentJob.setLiked(true);

                JobDatabase.getDatabase(viewHolder.getTextViewCompany().getContext()).JobDao().updateJob(currentJob);
            }
        });

    }


    @Override
    public int getItemCount() {
        return jobList.size();
    }
}