package com.zemoso.employee.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
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
    private String role;
    private String location;
    private String startDate;
    private String imageUrl;
    private String email;
    private String phoneNumber;
    private String bio;
    private ArrayList<String> skills;
    private String reportsTo;
    private String department;
    private String project;

    public Employee(String id, String firstName, String middleName, String lastName, String role, String location, String startDate, String imageUrl, String email, String phoneNumber, String bio, ArrayList<String> skills, String reportsTo, String department, String project) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.role = role;
        this.location = location;
        this.startDate = startDate;
        this.imageUrl = imageUrl;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.skills = skills;
        this.reportsTo = reportsTo;
        this.department = department;
        this.project = project;
    }

    public Employee(){

    }

}
