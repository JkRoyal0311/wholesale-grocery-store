package com.wholesale.grocery_store.controller;
import com.wholesale.grocery_store.entity.Cart;
import com.wholesale.grocery_store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long customerId){
        return ResponseEntity.ok(cartService.getOrCreateCart(customerId));
    }
    @PostMapping("/{customerId}/add")
    public ResponseEntity<Cart> addItem(@PathVariable Long customerId, @RequestParam Long productId, @RequestParam Double quantity){
        return ResponseEntity.ok(cartService.addItemToCart(customerId,productId,quantity));
    }
    @DeleteMapping("/{customerId}/remove/{cartItemId}")
    public ResponseEntity<Cart> removeItem(@PathVariable Long customerId, @PathVariable Long cartItemId){
        return ResponseEntity.ok(cartService.removeItemFromCart(cartItemId,customerId));
    }
}