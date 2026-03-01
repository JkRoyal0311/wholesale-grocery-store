package com.wholesale.grocery_store.service;
import com.wholesale.grocery_store.entity.*;
import com.wholesale.grocery_store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CustomerService customerService;
    public Order placeOrder(Long customerId){
        Cart cart = cartService.getOrCreateCart(customerId);
        Customer customer = customerService.getCustomerById(customerId);
        Order order = new Order();
        order.setCustomer(customer);
        order.setTotalAmount(cart.getTotalAmount());
        Order savedOrder = orderRepository.save(order);
        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());
        List<OrderItem> orderItems = cartItems.stream().map(cartItem->{
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPriceAtOrder(cartItem.getPriceAtAdded());
            orderItem.setTotalPrice(cartItem.getPriceAtAdded() * cartItem.getQuantity());
            return orderItem;
        }).collect(Collectors.toList());
        orderItemRepository.saveAll(orderItems);
        cartItemRepository.deleteAll(cartItems);
        cart.setTotalAmount(0.0);
        cartRepository.save(cart);
        return savedOrder;
    }
    public List<Order> getOrdersByCustomer(Long customerId){
        return orderRepository.findByCustomerId(customerId);
    }
    public Order updateOrderStatus(Long orderId, String status){
        Order order = orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}