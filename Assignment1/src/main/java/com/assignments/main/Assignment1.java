package com.assignments.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.assignments.beans.Person;
import com.assignments.beans.Vehicle;
import com.assignments.config.ProjectConfig;

public class Assignment1 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        String[] persons = context.getBeanNamesForType(Person.class);
        Person person = context.getBean(Person.class);
        String[] names = context.getBeanNamesForType(Vehicle.class);
        /*Vehicle vehicle = context.getBean(Vehicle.class);
        vehicle.getVehicleServices().playMusic();
        vehicle.getVehicleServices().moveVehicle();*/
        System.out.println(person.getName() + " is going on a " + person.getVehicle().toString());
        person.getVehicle().getVehicleServices().playMusic();
        person.getVehicle().getVehicleServices().moveVehicle();
    }
}

