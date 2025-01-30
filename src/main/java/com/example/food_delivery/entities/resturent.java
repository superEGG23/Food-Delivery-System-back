package com.example.food_delivery.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "resturents")
@Data
public class resturent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String open;
}
