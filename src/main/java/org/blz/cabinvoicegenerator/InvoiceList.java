package org.blz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Invoice_List {

    Map<String, ArrayList<Rides>> RideMap;

    public Invoice_List() {
        this.RideMap = new HashMap<>();
    }

    public void addRides(String id, ArrayList<Rides> rides) {
        if (id != null)
            RideMap.put(id, rides);
    }

    public ArrayList<Rides> getRides(String id) {
        if (RideMap.containsKey(id))
            return RideMap.get(id);
        else
            return null;
    }
}