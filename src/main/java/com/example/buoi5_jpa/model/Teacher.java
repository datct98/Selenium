package com.example.buoi5_jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "account_num")
    private String accountNum;
    @ManyToMany(mappedBy = "teachers")
    private Set<Clasz> claszs;
}
