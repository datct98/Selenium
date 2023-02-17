package com.example.buoi5_jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;

    @Column(columnDefinition = "varchar(30) default 'studying'", nullable = false)
    private String status;
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
