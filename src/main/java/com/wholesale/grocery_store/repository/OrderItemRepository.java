package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{
    List<OrderItem> findByOrderId(Long orderId);
}