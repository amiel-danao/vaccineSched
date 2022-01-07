package com.example.thesis;

public class BrgyValidation extends Validation{
    
    private final String[] VALID_BRGYS = new String[] {"salawag", "brgy. salawag", "brgy.salawag"};
    
    @Override
    public boolean isValid(String brgyNameToCheck){
        for(String thisCity : VALID_BRGYS) {
            if(thisCity.toLowerCase().trim().equals(brgyNameToCheck.toLowerCase().trim())){
                return true;
            }
        }
        return false;
    }
}
