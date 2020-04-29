package com.basho.retailstoreboot.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AffiliateDiscountTest {

    private Bill bill;
    private AffiliateDiscount discount;

    @BeforeEach
    void init() {
        bill = Mockito.mock(Bill.class);
        discount = new AffiliateDiscount();
    }

    @Test
    void whenNonGroceryTotal_100_then_getDiscountShouldReturn_10() {
        Mockito.when(bill.getNonGroceryTotal()).thenReturn(Double.valueOf(100));
        assertEquals(10, Double.valueOf(discount.getDiscount(bill)).intValue());
    }

}