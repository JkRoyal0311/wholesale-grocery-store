package com.wholesale.grocery_store.service;
import com.wholesale.grocery_store.entity.CustomerCategory;
import com.wholesale.grocery_store.repository.CustomerCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerCategoryService {
    @Autowired
    private CustomerCategoryRepository categoryRepository;
    public CustomerCategory createCategory(CustomerCategory category){
        return categoryRepository.save(category);
    }
    public List<CustomerCategory> getAllCategories(){
        return categoryRepository.findAll();
    }
    public CustomerCategory getCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
    }
    public CustomerCategory updateCategory(Long id, CustomerCategory updated){
        CustomerCategory existing = getCategoryById(id);
        existing.setCategoryName(updated.getCategoryName());
        existing.setDescription(updated.getDescription());
        existing.setMinMonthlyPurchase(updated.getMinMonthlyPurchase());
        existing.setDiscountPercentage(updated.getDiscountPercentage());
        return categoryRepository.save(existing);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}