package com.example.thesis.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegisterList implements Serializable {

    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("gender")
    @Expose
    private String gender;


    public String getLastName() {
        return last_name;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getGender() {
        return first_name;
    }

}
