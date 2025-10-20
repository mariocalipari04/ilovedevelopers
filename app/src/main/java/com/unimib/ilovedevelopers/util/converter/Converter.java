package com.unimib.ilovedevelopers.util.converter;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unimib.ilovedevelopers.model.api.response.country.Flags;
import com.unimib.ilovedevelopers.model.api.response.country.Name;

public class Converter {
    private static final Gson gson = new Gson();

    @TypeConverter
    public static String fromName(Name name) {
        return gson.toJson(name);
    }

    @TypeConverter
    public static Name toName(String value) {
        return gson.fromJson(value, Name.class);
    }

    // Se hai altri oggetti complessi come Flags
    @TypeConverter
    public static String fromFlags(Flags flags) {
        return gson.toJson(flags);
    }

    @TypeConverter
    public static Flags toFlags(String value) {
        return gson.fromJson(value, Flags.class);
    }
}