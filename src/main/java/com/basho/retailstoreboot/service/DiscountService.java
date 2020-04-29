package com.basho.retailstoreboot.service;

import com.basho.retailstoreboot.DiscountKeyEnum;
import com.basho.retailstoreboot.DiscountTypeEnum;
import com.basho.retailstoreboot.entity.Discount;
import com.basho.retailstoreboot.repository.DiscountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    private final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Discount findByKey(DiscountKeyEnum key) {
        return discountRepository.findByKey(key);
    }

    public List<Discount> findAllByType(DiscountTypeEnum type) {
        return discountRepository.findAllByType(type);
    }

}
