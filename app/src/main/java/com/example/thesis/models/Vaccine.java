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
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("atccode")
    @Expose
    private String atccode;
    @SerializedName("target")
    @Expose
    private String target;
    @SerializedName("storage")
    @Expose
    private String storage;
    @SerializedName("mimsclass")
    @Expose
    private String mimsclass;
    @SerializedName("atcclassification")
    @Expose
    private String atcclassification;
    @SerializedName("precautions")
    @Expose
    private String precautions;
    @SerializedName("adversereaction")
    @Expose
    private String adversereaction;
    @SerializedName("druginteractions")
    @Expose
    private String druginteractions;
    @SerializedName("contraindications")
    @Expose
    private String contraindications;
    @SerializedName("expdate")
    @Expose
    private Date expdate;



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

    public String getManufacturer() {
        return manufacturer;
    }
    public String getAtccode() {
        return atccode;
    }
    public String getTarget() {
        return target;
    }
    public String getStorage() {
        return storage;
    }
}
