package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Double quantity;
    private Double priceAtOrder;
    private Double totalPrice;
}