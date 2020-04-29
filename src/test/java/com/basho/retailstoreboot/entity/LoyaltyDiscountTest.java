package com.basho.retailstoreboot.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyaltyDiscountTest {
    private Bill bill;
    private Customer customer;
    private LoyaltyDiscount discount;

    @BeforeEach
    void init() {
        bill = Mockito.mock(Bill.class);
        customer = Mockito.mock(Customer.class);
        discount = new LoyaltyDiscount();
    }

    @Test
    void whenNewCustomerANDNonGroceryTotal_100_then_getDiscountShouldReturn_0() {
        Mockito.when(bill.getNonGroceryTotal()).thenReturn(Double.valueOf(100));
        Mockito.when(bill.getCustomer()).thenReturn(customer);
        Mockito.when(customer.getDateCreated()).thenReturn(LocalDateTime.now());

        assertEquals(0, discount.getDiscount(bill));
    }

    @Test
    void whenOldCustomerANDNonGroceryTotal_100_then_getDiscountShouldReturn_5() {

        Mockito.when(bill.getNonGroceryTotal()).thenReturn(Double.valueOf(100));
        Mockito.when(bill.getCustomer()).thenReturn(customer);
        Mockito.when(customer.getDateCreated()).thenReturn(LocalDateTime.now().minusYears(3));

        assertEquals(5, discount.getDiscount(bill));
    }
}