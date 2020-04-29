package com.basho.retailstoreboot.entity;

import com.basho.retailstoreboot.DiscountKeyEnum;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(DiscountKeyEnum.Values.FLAT)
public class FlatDiscount extends CustomDiscount {

    public FlatDiscount() {
        super(DiscountKeyEnum.FLAT);
    }

    @Transient
    @Override
    public double getDiscount(Bill bill) {
        return Double.valueOf(bill.getTotal() / 100).intValue() * 5;
    }

    @Transient
    @Override
    public boolean isApplicable(Bill bill) {
        return true;
    }

}
