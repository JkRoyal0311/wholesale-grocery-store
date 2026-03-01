package com.wholesale.grocery_store.repository;
import com.wholesale.grocery_store.entity.PricingRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface PricingRuleRepository extends JpaRepository<PricingRule,Long>{
    Optional<PricingRule> findByProductIdAndCategoryId(Long productId, Long categoryId);
}