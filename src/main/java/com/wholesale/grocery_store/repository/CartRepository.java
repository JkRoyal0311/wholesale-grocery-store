package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface CartRepository extends JpaRepository<Cart,Long>{
    Optional<Cart> findByCustomerId(Long customerId);
}