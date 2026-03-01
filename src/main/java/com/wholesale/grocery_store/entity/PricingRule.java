package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Data;
@Entity
@Table(name = "pricing_rules")
public class PricingRule {
	
    public PricingRule(Long id, Product product, CustomerCategory category, Double specialPrice,
			Double discountPercentage, Boolean isActive) {
		super();
		this.id = id;
		this.product = product;
		this.category = category;
		this.specialPrice = specialPrice;
		this.discountPercentage = discountPercentage;
		this.isActive = isActive;
	}
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public CustomerCategory getCategory() {
		return category;
	}
	public void setCategory(CustomerCategory category) {
		this.category = category;
	}
	public Double getSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}
	public Double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public PricingRule(){}
}