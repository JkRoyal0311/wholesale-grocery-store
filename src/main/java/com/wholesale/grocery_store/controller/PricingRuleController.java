package com.wholesale.grocery_store.controller;
import com.wholesale.grocery_store.entity.PricingRule;
import com.wholesale.grocery_store.service.PricingRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/pricing")
@CrossOrigin(origins = "*")
public class PricingRuleController {
    @Autowired
    private PricingRuleService pricingRuleService;
    @PostMapping
    public ResponseEntity<PricingRule> createRule(@RequestBody PricingRule rule){
        return ResponseEntity.ok(pricingRuleService.createRule(rule));
    }
    @GetMapping
    public ResponseEntity<List<PricingRule>> getAllRules(){
        return ResponseEntity.ok(pricingRuleService.getAllRules());
    }
    @GetMapping("/price")
    public ResponseEntity<Double> getPrice(@RequestParam Long productId, @RequestParam Long categoryId, @RequestParam Double basePrice){
        return ResponseEntity.ok(pricingRuleService.getPriceForCustomer(productId,categoryId,basePrice));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable Long id){
        pricingRuleService.deleteRule(id);
        return ResponseEntity.ok("Rule deleted");
    }
}