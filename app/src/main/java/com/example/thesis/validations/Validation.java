package com.example.thesis.validations;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thesis.FormMessages;

public abstract class Validation implements FormMessages {

    protected Context context;
    protected String successMessage;
    protected String errorMessage;
    protected EditText editText;
    protected TextView textView;

    public Validation(Context context, EditText editText) {
        this.context = context;
        this.editText = editText;
    }

    public boolean isValid(){
        if(editText != null){
            return isValid(editText);
        }

        if(textView != null){
            return isValid(textView);
        }

        return false;
    }
    public abstract boolean isValid(String toCheck);
    public boolean isValid(EditText toCheck){
        return isValid(toCheck.getText().toString());
    }

    public boolean isValid(TextView toCheck){
        return isValid(toCheck.getText().toString());
    }
    
    @Override
    public String getSuccessMessage(){
        return this.successMessage;
    }
    
    @Override
    public String getErrorMessage(){
        return this.errorMessage;
    }

    @Override
    public void showError(){
        if(editText != null){
            editText.setError(errorMessage);
        }

        if(textView != null){
            textView.setError(errorMessage);
        }
    }
}
