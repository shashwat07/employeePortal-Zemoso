package com.zemoso.role.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="role")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int id;
    private String name;

}

