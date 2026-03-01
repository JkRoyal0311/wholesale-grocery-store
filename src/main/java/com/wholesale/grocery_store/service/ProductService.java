package com.wholesale.grocery_store.service;
import com.wholesale.grocery_store.entity.Product;
import com.wholesale.grocery_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product createProduct(Product product){
        product.setIsActive(true);
        return productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findByIsActiveTrue();
    }
    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
    }
    public List<Product> searchProducts(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public Product updateProduct(Long id, Product updated){
        Product existing = getProductById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setUnit(updated.getUnit());
        existing.setBasePrice(updated.getBasePrice());
        existing.setCategory(updated.getCategory());
        return productRepository.save(existing);
    }
    public void deleteProduct(Long id){
        Product product = getProductById(id);
        product.setIsActive(false);
        productRepository.save(product);
    }
}