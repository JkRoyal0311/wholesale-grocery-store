package com.wholesale.grocery_store.service;
import com.wholesale.grocery_store.entity.Customer;
import com.wholesale.grocery_store.entity.CustomerCategory;
import com.wholesale.grocery_store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerCategoryService categoryService;
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
    }
    public Customer updateCategory(Long customerId, Long categoryId){
        Customer customer = getCustomerById(customerId);
        CustomerCategory category = categoryService.getCategoryById(categoryId);
        customer.setCategory(category);
        return customerRepository.save(customer);
    }
    public Customer updateMonthlyPurchase(Long customerId, Double amount){
        Customer customer = getCustomerById(customerId);
        customer.setTotalMonthlyPurchase(amount);
        return customerRepository.save(customer);
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}