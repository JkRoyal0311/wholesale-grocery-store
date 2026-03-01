package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}