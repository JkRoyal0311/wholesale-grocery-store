package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Double quantity;
    private Double reorderLevel;
    private LocalDateTime lastUpdated;
    @PrePersist
    @PreUpdate
    protected void onUpdate(){
        lastUpdated = LocalDateTime.now();
    }
}