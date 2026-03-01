package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface InventoryRepository extends JpaRepository<Inventory,Long>{
    Optional<Inventory> findByProductId(Long productId);
}