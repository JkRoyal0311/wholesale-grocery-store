package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Data;
@Entity
@Table(name = "products")
public class Product {
	
    public Product(Long id, String name, String description, String unit, Double basePrice, String category,
			Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unit = unit;
		this.basePrice = basePrice;
		this.category = category;
		this.isActive = isActive;
	}
    public Product(){}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String unit;
    private Double basePrice;
    private String category;
    private Boolean isActive;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
    
}