package com.example.thesis.adapters;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.thesis.models.Question;
import com.example.thesis.utilities.Generic;
import com.example.thesis.views.ChecklistItemViewHolder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChecklistItemAdapter extends RecyclerView.Adapter<ChecklistItemViewHolder> {

    private List<Question> questionList = new ArrayList<>();

    @Override
    public ChecklistItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ChecklistItemViewHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(ChecklistItemViewHolder holder, int position) {
        holder.setChecklistItem(questionList.get(position), position, new ChecklistItemViewHolder.OnCheckListItemChangedListener() {

            @Override
            public void onCheckChanged(int position, boolean checked) {
                questionList.get(position).setChecked(checked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public void setChecklistItems(List<Question> items) {
        questionList.clear();

        if (items != null) {
            questionList.addAll(items);
        }

        notifyDataSetChanged();
    }

    public void addChecklistItem(Question item) {
        if (item != null) {
            questionList.add(item);
            notifyDataSetChanged();
        }
    }

    public List<Question> getList() {
        return questionList;
    }

    public String getJsonAnswers() {
        JSONObject json=new JSONObject();

        for (int i=0; i<getItemCount()-1; i++) {
            try {
                json.put(String.valueOf(questionList.get(i).getId()), questionList.get(i).isChecked()? "1": "0");
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }

        String retVal = json.toString();
        Log.d(Generic.TAG, retVal);
        return retVal;
    }
}
