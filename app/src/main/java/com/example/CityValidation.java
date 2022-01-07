package com.example.thesis;

public class CityValidation extends Validation{
    
    private final String[] VALID_CITIES = new String[] {"dasmariñas", "dasmariñas city", "dasma"};
    
    @Override
    public boolean isValid(String cityNameToCheck){
        for(String thisCity : VALID_CITIES) {
            if(thisCity.toLowerCase().trim().equals(cityNameToCheck.toLowerCase().trim())){
                return true;
            }
        }
        return false;
    }
}
