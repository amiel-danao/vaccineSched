package com.example.thesis.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Vaccine implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("quantity")
    @Expose
    private int quantity;
    @SerializedName("dose")
    @Expose
    private int dose;
    @SerializedName("date")
    @Expose
    private Date date;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDose() {
        return dose;
    }

    public Date getDate() {
        return date;
    }
}
