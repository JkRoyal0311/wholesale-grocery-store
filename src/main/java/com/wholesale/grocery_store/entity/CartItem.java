package com.wholesale.grocery_store.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "cart_items")
public class CartItem {
	
    public CartItem(Long id, Cart cart, Product product, Double quantity, Double priceAtAdded) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
		this.priceAtAdded = priceAtAdded;
	}
    public CartItem(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
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
	public Double getPriceAtAdded() {
		return priceAtAdded;
	}
	public void setPriceAtAdded(Double priceAtAdded) {
		this.priceAtAdded = priceAtAdded;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Double quantity;
    private Double priceAtAdded;
}