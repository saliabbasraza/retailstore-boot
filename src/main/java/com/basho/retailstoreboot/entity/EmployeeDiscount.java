package com.basho.retailstoreboot.entity;

import com.basho.retailstoreboot.CustomerTypeEnum;
import com.basho.retailstoreboot.DiscountKeyEnum;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(DiscountKeyEnum.Values.EMPLOYEE)
public class EmployeeDiscount extends PercentageDiscount {

    public EmployeeDiscount() {
        super(DiscountKeyEnum.EMPLOYEE, 0.3);
    }

    @Transient
    @Override
    public boolean isApplicable(Bill bill) {
        return CustomerTypeEnum.EMPLOYEE.equals(bill.getCustomer().getType());
    }
}
