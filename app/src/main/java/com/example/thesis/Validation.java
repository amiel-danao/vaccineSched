package com.example.thesis;

import android.widget.EditText;
import android.widget.TextView;

public abstract class Validation implements FormMessages{
    
    protected String successMessage;
    protected String errorMessage;
    
    public abstract boolean isValid();
    public abstract boolean isValid(String toCheck);
    public abstract boolean isValid(int toCheck);
    public abstract boolean isValid(EditText toCheck);
    public abstract boolean isValid(TextView toCheck);
    
    @Override
    public String getSuccessMessage(){
        return this.successMessage;
    }
    
    @Override
    public String getErrorMessage(){
        return this.errorMessage;
    }
}
