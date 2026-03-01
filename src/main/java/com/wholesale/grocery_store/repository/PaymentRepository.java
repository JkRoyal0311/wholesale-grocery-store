package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PaymentRepository extends JpaRepository<Payment,Long>{
    List<Payment> findByCustomerId(Long customerId);
}