package com.wholesale.grocery_store.service;
import com.wholesale.grocery_store.entity.*;
import com.wholesale.grocery_store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerService customerService;
    public Payment makePayment(Long orderId, String paymentMethod){
        Order order = orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Order not found"));
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setCustomer(order.getCustomer());
        payment.setAmount(order.getTotalAmount());
        payment.setPaymentMethod(paymentMethod);
        payment.setStatus("SUCCESS");
        order.setStatus("CONFIRMED");
        orderRepository.save(order);
        return paymentRepository.save(payment);
    }
}