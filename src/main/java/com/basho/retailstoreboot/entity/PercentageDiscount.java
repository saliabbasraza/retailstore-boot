package com.basho.retailstoreboot.entity;

import com.basho.retailstoreboot.DiscountKeyEnum;
import com.basho.retailstoreboot.DiscountTypeEnum;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@NoArgsConstructor
public abstract class PercentageDiscount extends Discount {

    public PercentageDiscount(DiscountKeyEnum key, Double ratio) {
        super(null, key, ratio, DiscountTypeEnum.PERCENTAGE);
    }

    @Transient
    @Override
    public double getDiscount(Bill bill) {
        return bill.getNonGroceryTotal() * getRatio();
    }
}
