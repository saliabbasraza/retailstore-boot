package com.basho.retailstoreboot.repository;

import com.basho.retailstoreboot.entity.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {
}
