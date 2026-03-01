package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Data;
@Entity
@Table(name = "customer_category")
public class CustomerCategory {
	
    public CustomerCategory(Long id, String categoryName, String description, Double minMonthlyPurchase,
			Double discountPercentage) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
		this.minMonthlyPurchase = minMonthlyPurchase;
		this.discountPercentage = discountPercentage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getMinMonthlyPurchase() {
		return minMonthlyPurchase;
	}
	public void setMinMonthlyPurchase(Double minMonthlyPurchase) {
		this.minMonthlyPurchase = minMonthlyPurchase;
	}
	public Double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String description;
    private Double minMonthlyPurchase; 
    private Double discountPercentage; 
}
