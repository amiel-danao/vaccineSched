package com.example.thesis.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question implements Serializable {

	@SerializedName("question")
    @Expose
    private String question;
    private boolean isChecked;
	@SerializedName("id")
    @Expose
    private int id;
    @SerializedName("category")
    @Expose
    private String category;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }
}
