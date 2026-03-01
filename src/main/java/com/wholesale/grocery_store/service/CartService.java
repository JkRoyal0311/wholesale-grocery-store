package com.wholesale.grocery_store.service;
import com.wholesale.grocery_store.entity.*;
import com.wholesale.grocery_store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private PricingRuleService pricingRuleService;
    @Autowired
    private CustomerService customerService;
    public Cart getOrCreateCart(Long customerId){
        return cartRepository.findByCustomerId(customerId).orElseGet(()->{
            Cart cart = new Cart();
            cart.setCustomer(customerService.getCustomerById(customerId));
            cart.setTotalAmount(0.0);
            return cartRepository.save(cart);
        });
    }
    public Cart addItemToCart(Long customerId, Long productId, Double quantity){
        Cart cart = getOrCreateCart(customerId);
        Customer customer = customerService.getCustomerById(customerId);
        Product product = productService.getProductById(productId);
        Double price = pricingRuleService.getPriceForCustomer(productId, customer.getCategory().getId(), product.getBasePrice());
        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setPriceAtAdded(price);
        cartItemRepository.save(item);
        cart.setTotalAmount(cart.getTotalAmount() + (price * quantity));
        return cartRepository.save(cart);
    }
    public Cart removeItemFromCart(Long cartItemId, Long customerId){
        Cart cart = getOrCreateCart(customerId);
        CartItem item = cartItemRepository.findById(cartItemId).orElseThrow(()->new RuntimeException("Item not found"));
        cart.setTotalAmount(cart.getTotalAmount() - (item.getPriceAtAdded() * item.getQuantity()));
        cartItemRepository.deleteById(cartItemId);
        return cartRepository.save(cart);
    }
}