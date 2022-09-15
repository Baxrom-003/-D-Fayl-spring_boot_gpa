package com.example.spring_boot_gpa.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Xodim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String fish;
    @Column(nullable = false)
    private String lavozim;
    @Column(nullable = false)
    private double maosh;
    @Column(nullable = false,unique = true)
    private String email;



}
