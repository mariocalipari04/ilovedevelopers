package com.unimib.ilovedevelopers.model.api.response.country;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "countries")
public class CountryEntity {
        @PrimaryKey
        @NonNull
        private String code;

        @NonNull
        private Name name;
        @NonNull
        private Flags flags;
        @NonNull
        private String cca2;

        public CountryEntity(@NonNull String code, @NonNull Name name, @NonNull Flags flags, @NonNull String cca2) {
            this.code = code;
            this.name = name;
            this.flags = flags;
            this.cca2 = cca2;
        }

        public String getCca2() {
            return cca2;
        }

        public void setCca2(String cca2) {
            this.cca2 = cca2;
        }

        @NonNull
        public String getCode() { return code; }
        public void setCode(@NonNull String code) { this.code = code; }

        public Name getName() { return name; }
        public void setName(Name name) { this.name = name; }

        public Flags getFlags() { return flags; }
        public void setFlags(Flags flags) { this.flags = flags; }
    }

