package com.basho.retailstoreboot.entity;

import com.basho.retailstoreboot.CustomerTypeEnum;
import com.basho.retailstoreboot.DiscountKeyEnum;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(DiscountKeyEnum.Values.AFFILIATE)
public class AffiliateDiscount extends PercentageDiscount {


    public AffiliateDiscount() {
        super(DiscountKeyEnum.AFFILIATE, 0.1);
    }

    @Transient
    @Override
    public boolean isApplicable(Bill bill) {
        return CustomerTypeEnum.AFFILIATE.equals(bill.getCustomer().getType());
    }
}
