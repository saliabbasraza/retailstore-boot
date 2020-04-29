package com.basho.retailstoreboot.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeDiscountTest {

    private Bill bill;
    private EmployeeDiscount discount;

    @BeforeEach
    void init() {
        bill = Mockito.mock(Bill.class);
        discount = new EmployeeDiscount();
    }

    @Test
    void whenNonGroceryTotal_100_then_getDiscountShouldReturn_30() {
        Mockito.when(bill.getNonGroceryTotal()).thenReturn(Double.valueOf(100));
        assertEquals(30, Double.valueOf(discount.getDiscount(bill)).intValue());
    }
}