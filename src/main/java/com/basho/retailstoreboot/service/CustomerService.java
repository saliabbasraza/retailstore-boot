package com.basho.retailstoreboot.service;

import com.basho.retailstoreboot.entity.Customer;
import com.basho.retailstoreboot.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id).get();
    }
}
