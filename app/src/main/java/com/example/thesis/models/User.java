package com.example.thesis.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable, Cloneable {

    @SerializedName("user_id")
    @Expose
    private int user_id;
    @SerializedName("dateofbirth")
    @Expose
    private Date dateofbirth;
    @SerializedName("placeofbirth")
    @Expose
    private String placeofbirth;
    @SerializedName("mothersname")
    @Expose
    private String mothersname;
    @SerializedName("fathersname")
    @Expose
    private String fathersname;
    @SerializedName("birthheight")
    @Expose
    private float birthheight;
    @SerializedName("birthweight")
    @Expose
    private float birthweight;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("baranggay")
    @Expose
    private String baranggay;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("phone")
    @Expose
    private String phone;

    public User(int user_id, Date dateofbirth, String placeofbirth, String mothersname, String fathersname, float birthheight, float birthweight, String sex, String firstname, String lastname, String city, String baranggay, String email, String password, String phone) {
        this.user_id = user_id;
        this.dateofbirth = dateofbirth;
        this.placeofbirth = placeofbirth;
        this.mothersname = mothersname;
        this.fathersname = fathersname;
        this.birthheight = birthheight;
        this.birthweight = birthweight;
        this.sex = sex;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.baranggay = baranggay;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getMothersname() {
        return mothersname;
    }

    public void setMothersname(String mothersname) {
        this.mothersname = mothersname;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

    public float getBirthheight() {
        return birthheight;
    }

    public void setBirthheight(float birthheight) {
        this.birthheight = birthheight;
    }

    public float getBirthweight() {
        return birthweight;
    }

    public void setBirthweight(float birthweight) {
        this.birthweight = birthweight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBaranggay() {
        return baranggay;
    }

    public void setBaranggay(String baranggay) {
        this.baranggay = baranggay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public String getStringPhone() {
        return phone == null? "" : phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirthString() {

        return dateofbirth == null? "" : dateofbirth.toString();
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
