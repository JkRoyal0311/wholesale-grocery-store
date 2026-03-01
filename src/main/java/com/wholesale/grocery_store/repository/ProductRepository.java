package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product,Long>{
    List<Product> findByIsActiveTrue();
    List<Product> findByNameContainingIgnoreCase(String name);
}