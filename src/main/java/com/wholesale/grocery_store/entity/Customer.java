package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;

import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Table(name = "customers")
public class Customer {
	
    public Customer(Long id, String name, String phone, String email, String address, CustomerCategory category,
			Double totalMonthlyPurchase, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.category = category;
		this.totalMonthlyPurchase = totalMonthlyPurchase;
		this.createdAt = createdAt;
	}
    public Customer(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public CustomerCategory getCategory() {
		return category;
	}
	public void setCategory(CustomerCategory category) {
		this.category = category;
	}
	public Double getTotalMonthlyPurchase() {
		return totalMonthlyPurchase;
	}
	public void setTotalMonthlyPurchase(Double totalMonthlyPurchase) {
		this.totalMonthlyPurchase = totalMonthlyPurchase;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CustomerCategory category;
    private Double totalMonthlyPurchase;
    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
    }
}