package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String unit;
    private Double basePrice;
    private String category;
    private Boolean isActive;
}