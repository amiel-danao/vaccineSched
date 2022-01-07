package com.example.thesis;

public class PhoneNumberValidation extends Validation{
    
    private final int PHONE_MAX_LENGTH = 11;
    
    @Override
    public boolean isValid(String phoneNumberToCheck){
        if(TextUtils.isEmpty(phoneNumberToCheck.trim())){
            return false;
        }
        
        return phoneNumberToCheck.length() <= PHONE_MAX_LENGTH; 
    }
}
