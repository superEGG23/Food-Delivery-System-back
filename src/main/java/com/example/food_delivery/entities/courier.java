package com.example.food_delivery.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "couriers")
@Data
public class courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String location;

}
