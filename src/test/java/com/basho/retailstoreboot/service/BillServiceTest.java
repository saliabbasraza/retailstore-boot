package com.basho.retailstoreboot.service;

import com.basho.retailstoreboot.CustomerTypeEnum;
import com.basho.retailstoreboot.DiscountKeyEnum;
import com.basho.retailstoreboot.DiscountTypeEnum;
import com.basho.retailstoreboot.entity.*;
import com.basho.retailstoreboot.repository.BillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
class BillServiceTest {
    private BillRepository billRepository;
    private BillService billService;
    private DiscountService discountService;
    private CustomerService customerService;

    private static List<Discount> discounts;
    private static FlatDiscount flatDiscount;
    private static EmployeeDiscount employeeDiscount;

    @BeforeAll
    public static void init() {
        flatDiscount = new FlatDiscount();
        flatDiscount.setId(1l);
        employeeDiscount = new EmployeeDiscount();
        employeeDiscount.setId(2l);

        discounts = Arrays.asList(flatDiscount, employeeDiscount);
    }

    @BeforeEach
    public void setUp() {
        billRepository = Mockito.mock(BillRepository.class);
        discountService = Mockito.mock(DiscountService.class);
        customerService = Mockito.mock(CustomerService.class);
        billService = new BillService(billRepository, discountService, customerService);
    }

    @Test
    void applyDiscount_ShouldAddDiscountsAndSetDiscountValue() throws Exception {

        Customer customer = Mockito.mock(Customer.class);
        Bill bill = new Bill(null, customer, 100d, 100d, null, null, null);

        given(customer.getDateCreated()).willReturn(LocalDateTime.now());
        given(customer.getType()).willReturn(CustomerTypeEnum.EMPLOYEE);
        given(discountService.findByKey(DiscountKeyEnum.FLAT)).willReturn(flatDiscount);
        given(discountService.findAllByType(DiscountTypeEnum.PERCENTAGE)).willReturn(Arrays.asList(employeeDiscount));


        Bill resp = billService.applyDiscount(bill);

        Assertions.assertAll("Should apply discounts",
                () -> Assertions.assertEquals(2, resp.getDiscounts().size()),
                () -> Assertions.assertEquals(40, resp.getDiscount().intValue()),
                () -> Assertions.assertEquals(160, resp.getNetPayable().intValue())
        );

    }
}