package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.Data;
@Entity
@Table(name = "payments")
public class Payment {
	
    public Payment(Long id, Order order, Customer customer, Double amount, String paymentMethod, String status,
			LocalDateTime paidAt) {
		super();
		this.id = id;
		this.order = order;
		this.customer = customer;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.paidAt = paidAt;
	}
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
    public Payment(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getPaidAt() {
		return paidAt;
	}
	public void setPaidAt(LocalDateTime paidAt) {
		this.paidAt = paidAt;
	}
}