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
@AllArgsConstructor
@NoArgsConstructor
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
}
