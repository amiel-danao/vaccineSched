package com.example.thesis;

public abstract class Validation implements FormMessages{
    
    protected int viewId;
    protected String successMessage;
    protected String errorMessage;
    
    public Validation(){}
    
    public Validation(int id){
        this.viewId = id;
    }
    
    public abstract boolean isValid();
    public abstract boolean isValid(String toCheck);
    public abstract boolean isValid(int toCheck);
    
    @Override
    public String getSuccessMessage(){
        return this.successMessage;
    }
    
    @Override
    public String getErrorMessage(){
        return this.errorMessage;
    }
}
