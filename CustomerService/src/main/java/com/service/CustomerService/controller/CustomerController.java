package com.service.CustomerService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.CustomerService.model.Customer;
import com.service.CustomerService.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
    	logger.info("saveCustomer");
    	return customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
    	logger.info("getAllCustomers");
    	return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
      return new Customer(id, "John");
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer customer) {
    	logger.info("updateCustomer");
    	return customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
    	logger.info("deleteCustomer - id is {}", id);
    	customerRepository.deleteById(id);
    }
}
