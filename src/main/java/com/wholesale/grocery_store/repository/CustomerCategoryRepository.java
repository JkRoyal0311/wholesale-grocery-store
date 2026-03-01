package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.CustomerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerCategoryRepository extends JpaRepository<CustomerCategory,Long>{
}