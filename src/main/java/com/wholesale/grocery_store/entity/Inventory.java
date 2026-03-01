package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.Data;
@Entity
@Table(name = "inventory")
public class Inventory {
	
    public Inventory(Long id, Product product, Double quantity, Double reorderLevel, LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.reorderLevel = reorderLevel;
		this.lastUpdated = lastUpdated;
	}
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
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(Double reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
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