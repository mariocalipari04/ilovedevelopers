package com.unimib.ilovedevelopers.model.api.response.country;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.SerializedName;

public class Country {

    /*
    private String name;
    private String code;

    private Drawable image;

    public Country(String name, String code, Drawable image){
        this.name = name;
        this.code = code;
        this.image = image;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Drawable getImage() {
        return image;
    }
     */

        @SerializedName("cca2")
        private String code;

        @SerializedName("name")
        private Name name;

        @SerializedName("flags")
        private Flags flags;

        @SerializedName("region")
        private String region;

        @SerializedName("subregion")
        private String subregion;

        public String getCode() { return code; }
        public String getCommonName() { return name.common; }
        public String getFlagPng() { return flags.png; }

        public static class Name { String common; }
        public static class Flags { String png; }
    }

