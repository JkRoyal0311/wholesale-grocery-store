package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "pricing_rules")
public class PricingRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CustomerCategory category;
    private Double specialPrice;
    private Double discountPercentage;
    private Boolean isActive;
}