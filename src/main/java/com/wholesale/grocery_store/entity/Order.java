package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
@Entity
@Table(name = "orders")
public class Order {
    
	public Order(Long id, Customer customer, String status, Double totalAmount, LocalDateTime orderedAt,
			List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.customer = customer;
		this.status = status;
		this.totalAmount = totalAmount;
		this.orderedAt = orderedAt;
		this.orderItems = orderItems;
	}
	public Order(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDateTime getOrderedAt() {
		return orderedAt;
	}
	public void setOrderedAt(LocalDateTime orderedAt) {
		this.orderedAt = orderedAt;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
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