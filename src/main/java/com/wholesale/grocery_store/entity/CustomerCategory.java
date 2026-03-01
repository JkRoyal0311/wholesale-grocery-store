package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "customer_category")
public class CustomerCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String description;
    private Double minMonthlyPurchase; 
    private Double discountPercentage; 
}
