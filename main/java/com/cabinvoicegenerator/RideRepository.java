package com.cabinvoicegenerator;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, Ride[]> userRides = new HashMap<>();

    public void addRideForUser(String userID,Ride[] rides) throws CabInvoiceException {
        if( userRides.containsKey(userID))
            throw new CabInvoiceException(CabInvoiceException.ExceptionType.USER_EXISTS_ALREADY, "User ID Already Exists!!");
        else
            userRides.put(userID, rides);
    }

    public Ride[] getRidesForUser(String userId) {
        return userRides.get(userId);
    }
}
