package com.zemoso.employee.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "employee_details")
@JsonIgnoreProperties
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String startDate;
    @Column(length = 65535, columnDefinition = "text")
    private String image;
    private String email;
    private String phoneNumber;
    private String bio;
    private String reportsTo;
    private String role;
    private String location;
    private String department;
    private String project;
    private String skillSet;


    public Employee(){}

    public Employee(Long id, String firstName, String middleName, String lastName, String startDate, String image, String email, String phoneNumber, String bio, String reportsTo, String role, String location, String skillSet, String department, String project) {
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
        this.skillSet = skillSet;

    }
}
