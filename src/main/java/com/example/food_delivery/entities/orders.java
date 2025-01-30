package com.example.food_delivery.entities;
import jakarta.persistence.*;
        import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customer;

    @Column(nullable = false)
    private String resturent;

    @Column(nullable = false)
    private String dish;

    @Column(nullable = false)
    private String address;
}
