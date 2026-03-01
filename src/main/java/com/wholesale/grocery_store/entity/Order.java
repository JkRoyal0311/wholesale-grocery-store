package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String status;
    private Double totalAmount;
    private LocalDateTime orderedAt;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    @PrePersist
    protected void onCreate(){
        orderedAt = LocalDateTime.now();
        status = "PENDING";
    }
}