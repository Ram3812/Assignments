package com.assignments.beans;

import com.assignments.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "vehicleBean")
public class Vehicle {
    private String name = "Lambo";
    @Autowired
    private VehicleService vehicleService;

    public VehicleService getVehicleServices() {
        return vehicleService;
    }

    public void setVehicleServices(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public String toString() {
        return name;
    }

}
