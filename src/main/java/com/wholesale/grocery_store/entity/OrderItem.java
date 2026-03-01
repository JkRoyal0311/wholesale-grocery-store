package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Data;
@Entity
@Table(name = "order_items")
public class OrderItem {
	
    public OrderItem(Long id, Order order, Product product, Double quantity, Double priceAtOrder, Double totalPrice) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.priceAtOrder = priceAtOrder;
		this.totalPrice = totalPrice;
	}
    public OrderItem(){}
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
	public Double getPriceAtOrder() {
		return priceAtOrder;
	}
	public void setPriceAtOrder(Double priceAtOrder) {
		this.priceAtOrder = priceAtOrder;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
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