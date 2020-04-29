package com.basho.retailstoreboot.repository;

import com.basho.retailstoreboot.DiscountKeyEnum;
import com.basho.retailstoreboot.DiscountTypeEnum;
import com.basho.retailstoreboot.entity.Discount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiscountRepository extends CrudRepository<Discount, Long> {
    List<Discount> findAllByType(DiscountTypeEnum type);

    Discount findByKey(DiscountKeyEnum key);
}
