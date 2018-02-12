package com.zemoso.skill.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="skill")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)
public class Skill {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int id;
    private String name;
}
