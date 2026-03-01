package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CartItemRepository extends JpaRepository<CartItem,Long>{
    List<CartItem> findByCartId(Long cartId);
}