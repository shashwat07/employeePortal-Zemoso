package com.zemoso.employee.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "employee_details")
@JsonIgnoreProperties
public class Employee {
    @Id
    private String id = UUID.randomUUID().toString();
    private String firstName;
    private String middleName;
    private String lastName;
    private String startDate;
    private String image;
    private String email;
    private String phoneNumber;
    private String bio;
    private String reportsTo;
    private String role;
    private String location;
    private String department;
    private String project;
    private ArrayList<String> skills;


    public Employee(){}

    public Employee(String id, String firstName, String middleName, String lastName, String startDate, String image, String email, String phoneNumber, String bio, String reportsTo, String role, String location, ArrayList<String> skills, String department, String project) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.image = image;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.reportsTo = reportsTo;
        this.role = role;
        this.location = location;
        this.department = department;
        this.project = project;
        this.skills = skills;
    }
}
