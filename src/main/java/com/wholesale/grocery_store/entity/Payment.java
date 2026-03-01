package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Double amount;
    private String paymentMethod;
    private String status;
    private LocalDateTime paidAt;
    @PrePersist
    protected void onCreate(){
        paidAt = LocalDateTime.now();
        status = "PENDING";
    }
}