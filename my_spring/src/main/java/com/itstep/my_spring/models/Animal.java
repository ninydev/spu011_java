package com.itstep.my_spring.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID id;
}
