package com.wholesale.grocery_store.controller;
import com.wholesale.grocery_store.entity.Payment;
import com.wholesale.grocery_store.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/{orderId}")
    public ResponseEntity<Payment> makePayment(@PathVariable Long orderId, @RequestParam String paymentMethod){
        return ResponseEntity.ok(paymentService.makePayment(orderId,paymentMethod));
    }
}