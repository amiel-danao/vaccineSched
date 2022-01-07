package com.example.thesis;

public abstract class Validation implements FormMessages{
    
    private String successMessage;
    private String errorMessage;
    
    public abstract boolean isValid();
    
    @Override
    public String getSuccessMessage(){
        return successMessage;
    }
    
    @Override
    public String getErrorMessage(){
        return errorMessage;
    }
}
