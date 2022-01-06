package com.ahmadabuhasan.volleygsonxampp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class User {

    @SerializedName("user_id")
    @Expose
    private int user_id;
    @SerializedName("dateofbirth")
    @Expose
    private Date dateofbirth;
    @SerializedName("placeofbirth")
    @Expose
    private String placeofbirth;

}
