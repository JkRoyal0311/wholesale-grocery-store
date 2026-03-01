package com.wholesale.grocery_store.service;
import com.wholesale.grocery_store.entity.PricingRule;
import com.wholesale.grocery_store.repository.PricingRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PricingRuleService {
    @Autowired
    private PricingRuleRepository pricingRuleRepository;
    public PricingRule createRule(PricingRule rule){
        rule.setIsActive(true);
        return pricingRuleRepository.save(rule);
    }
    public Double getPriceForCustomer(Long productId, Long categoryId, Double basePrice){
        return pricingRuleRepository.findByProductIdAndCategoryId(productId, categoryId)
            .map(rule -> rule.getSpecialPrice() != null ? rule.getSpecialPrice() : basePrice - (basePrice * rule.getDiscountPercentage() / 100))
            .orElse(basePrice);
    }
    public List<PricingRule> getAllRules(){
        return pricingRuleRepository.findAll();
    }
    public void deleteRule(Long id){
        pricingRuleRepository.deleteById(id);
    }
}