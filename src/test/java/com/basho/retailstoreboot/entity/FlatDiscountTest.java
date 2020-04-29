package com.basho.retailstoreboot.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlatDiscountTest {
    private Bill bill;
    private FlatDiscount discount;

    @BeforeEach
    void init() {
        bill = Mockito.mock(Bill.class);
        discount = new FlatDiscount();
    }

    @Test
    void whenTotal_100_then_getDiscountShouldReturn_5() {
        Mockito.when(bill.getTotal()).thenReturn(Double.valueOf(100));
        assertEquals(5, discount.getDiscount(bill));
    }

    @Test
    void whenTotal_99_then_getDiscountShouldReturn_0() {
        Mockito.when(bill.getTotal()).thenReturn(Double.valueOf(99));
        assertEquals(0, discount.getDiscount(bill));
    }
}