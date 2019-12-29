package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Optional<Customer> getCustomerById(long id);
    public Customer saveCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
    public List<Customer> findAll();
}
