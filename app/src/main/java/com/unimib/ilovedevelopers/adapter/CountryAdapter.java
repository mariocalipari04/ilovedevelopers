package com.unimib.ilovedevelopers.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.model.api.response.country.CountryEntity;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    public interface OnCountryClickListener {
        void onCountryClick(CountryEntity country);
    }

    private final Context context;
    private final List<CountryEntity> countries;
    private final OnCountryClickListener listener;

    public CountryAdapter(Context context, List<CountryEntity> countries, OnCountryClickListener listener) {
        this.context = context;
        this.countries = countries;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout. country_card, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        CountryEntity country = countries.get(position);
        holder.countryName.setText(country.getName().getCommon());

        Glide.with(context)
                .load(country.getFlags().getPng())
                .placeholder(R.drawable.placeholder_flag)
                .into(holder.flagImage);

        holder.itemView.setOnClickListener(v -> listener.onCountryClick(country));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        ImageView flagImage;
        TextView countryName;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            flagImage = itemView.findViewById(R.id.flagImageView);
            countryName = itemView.findViewById(R.id.countryNameTextView);
        }
    }
}