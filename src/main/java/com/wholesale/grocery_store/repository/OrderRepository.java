package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderRepository extends JpaRepository<Order,Long>{
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByStatus(String status);
}