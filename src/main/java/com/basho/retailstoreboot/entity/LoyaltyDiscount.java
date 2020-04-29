package com.basho.retailstoreboot.entity;

import com.basho.retailstoreboot.DiscountKeyEnum;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue(DiscountKeyEnum.Values.LOYALTY)
public class LoyaltyDiscount extends PercentageDiscount {

    public LoyaltyDiscount() {
        super(DiscountKeyEnum.LOYALTY, 0.05);
    }

    @Transient
    @Override
    public double getDiscount(Bill bill) {
        double discount = 0.0;
        if (isApplicable(bill)) {
            discount = bill.getNonGroceryTotal() * getRatio();
        }
        return discount;
    }

    @Transient
    @Override
    public boolean isApplicable(Bill bill) {
        return bill.getCustomer().getDateCreated().isBefore(LocalDateTime.now().minusYears(2));
    }
}
