package com.unimib.ilovedevelopers.model.api.response.job;

import android.location.Location;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Job {

    @NonNull
    @PrimaryKey
    private String id;
    private String title;
    private String description;
    private String created;
    private String adref;
    private String redirect_url;
    @Embedded(prefix ="company_")
    private Company company;
    @Ignore
    private Location location;
    @Embedded(prefix ="category_")
    private Category category;
    private double latitude;
    private double longitude;
    private String salary_is_predicted;

    private boolean liked;

    public Job() {}

    public boolean getLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAdref() {
        return adref;
    }

    public void setAdref(String adref) {
        this.adref = adref;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getSalary_is_predicted() {
        return salary_is_predicted;
    }

    public void setSalary_is_predicted(String salary_is_predicted) {
        this.salary_is_predicted = salary_is_predicted;
    }
}