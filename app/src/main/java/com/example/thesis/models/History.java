package com.example.thesis.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

public class History implements Serializable {
    @SerializedName("his_id")
    @Expose
    private int his_id;
    @SerializedName("appo_id")
    @Expose
    private int appo_id;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("appo_date")
    @Expose
    private Date appo_date;
    @SerializedName("appo_time")
    @Expose
    private String appo_time;
    @SerializedName("vaccine")
    @Expose
    private String vaccine;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("user_id")
    @Expose
    private int user_id;
    @SerializedName("nurse")
    @Expose
    private String nurse;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("for_id")
    @Expose
    private int for_id;
    @SerializedName("dose")
    @Expose
    private int dose;

    public int getAppo_id() {
        return appo_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public Date getAppo_date() {
        return appo_date;
    }

    public String getAppo_time() {
        return appo_time;
    }

    public String getVaccine() {
        return vaccine;
    }

    public int getDose() {
        return dose;
    }

    public String getStatus() {
        return status;
    }
}