package com.assignments.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "personBean")
public class Person {
    private String name = "Ram";
    private final Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Autowired
    public Person(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }
}
