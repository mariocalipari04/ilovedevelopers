package com.unimib.ilovedevelopers.model;

public class JobCategory {

    private String name;
    private String code;

    public JobCategory(String name, String code){
        this.name = name;
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
