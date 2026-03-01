package com.wholesale.grocery_store.controller;
import com.wholesale.grocery_store.entity.CustomerCategory;
import com.wholesale.grocery_store.service.CustomerCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CustomerCategoryController {
    @Autowired
    private CustomerCategoryService categoryService;
    @PostMapping
    public ResponseEntity<CustomerCategory> createCategory(@RequestBody CustomerCategory category){
        return ResponseEntity.ok(categoryService.createCategory(category));
    }
    @GetMapping
    public ResponseEntity<List<CustomerCategory>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerCategory> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerCategory> updateCategory(@PathVariable Long id, @RequestBody CustomerCategory category){
        return ResponseEntity.ok(categoryService.updateCategory(id,category));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted");
    }
}