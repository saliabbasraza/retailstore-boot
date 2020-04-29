package com.basho.retailstoreboot.repository;

import com.basho.retailstoreboot.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
