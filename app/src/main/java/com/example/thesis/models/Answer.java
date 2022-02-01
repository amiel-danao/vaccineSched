package com.example.thesis.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer implements Serializable {

	@SerializedName("answer_checklist")
    @Expose
    private int answerChecklist;
    @SerializedName("answer_screening")
    @Expose
    private int answerScreening;
    @SerializedName("user_id")
    @Expose
    private String user_id;

    public int getAnswerChecklist() {
        return answerChecklist;
    }

    public int getAnswerScreening() {
        return answerScreening;
    }

    public String getUser_id() {
        return user_id;
    }
}
