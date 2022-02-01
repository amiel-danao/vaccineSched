package com.example.thesis.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.thesis.R;
import com.example.thesis.models.Question;

public class ChecklistItemViewHolder extends RecyclerView.ViewHolder {

    public TextView noteText;

    public CheckBox isCheckedBox;

    public static ChecklistItemViewHolder newInstance(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checklist_note_list_item, parent, false);
        return new ChecklistItemViewHolder(view);
    }

    private ChecklistItemViewHolder(View itemView) {
        super(itemView);
        noteText = itemView.findViewById(R.id.checklist_item_label);
        isCheckedBox = itemView.findViewById(R.id.checklist_item_checkbox);
    }

    public void setChecklistItem(Question item, final int position, final OnCheckListItemChangedListener onCheckListItemChangedListener) {
        noteText.setText(item.getQuestion());

        isCheckedBox.setOnCheckedChangeListener(null);
        isCheckedBox.setChecked(item.isChecked());
        isCheckedBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (onCheckListItemChangedListener != null) {
                    onCheckListItemChangedListener.onCheckChanged(position, isChecked);
                }
            }
        });
    }

    public interface OnCheckListItemChangedListener {
        void onCheckChanged(int position, boolean checked);
    }
}
