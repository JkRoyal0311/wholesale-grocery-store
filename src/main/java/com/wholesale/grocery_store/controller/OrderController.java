package com.wholesale.grocery_store.controller;
import com.wholesale.grocery_store.entity.Order;
import com.wholesale.grocery_store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/{customerId}/place")
    public ResponseEntity<Order> placeOrder(@PathVariable Long customerId){
        return ResponseEntity.ok(orderService.placeOrder(customerId));
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable Long customerId){
        return ResponseEntity.ok(orderService.getOrdersByCustomer(customerId));
    }
    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long orderId, @RequestParam String status){
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId,status));
    }
}