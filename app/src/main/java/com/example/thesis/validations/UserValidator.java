package com.example.thesis.validations;

import com.example.thesis.models.User;

public class UserValidator {
    private User user;

    public UserValidator(User user){
        this.user = user;

    }

    public boolean isValid(){
        return true;
    }
}
