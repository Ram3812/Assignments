package com.assignments.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.assignments.implementation",
        "com.assignments.services"})
@ComponentScan(basePackageClasses = {com.assignments.beans.Vehicle.class,
        com.assignments.beans.Person.class})
public class ProjectConfig {

}
