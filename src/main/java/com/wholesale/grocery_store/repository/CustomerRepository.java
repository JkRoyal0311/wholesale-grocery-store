package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    Optional<Customer> findByPhone(String phone);
    Optional<Customer> findByEmail(String email);
}