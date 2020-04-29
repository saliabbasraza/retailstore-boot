package com.basho.retailstoreboot.entity;

import com.basho.retailstoreboot.DiscountKeyEnum;
import com.basho.retailstoreboot.DiscountTypeEnum;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public abstract class CustomDiscount extends Discount {
    public CustomDiscount(DiscountKeyEnum key) {
        super(null, key, 0.0, DiscountTypeEnum.CUSTOM);
    }
}
