package com.basho.retailstoreboot.service;

import com.basho.retailstoreboot.DiscountKeyEnum;
import com.basho.retailstoreboot.entity.Discount;
import com.basho.retailstoreboot.entity.FlatDiscount;
import com.basho.retailstoreboot.repository.DiscountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
class DiscountServiceTest {
    private DiscountRepository discountRepository;

    private DiscountService discountService;

    @BeforeEach
    public void setUp() throws Exception {
        discountRepository = Mockito.mock(DiscountRepository.class);
        discountService = new DiscountService(discountRepository);
    }

    @Test
    void findByKey_ShouldReturnDiscount() {

        Discount discount = new FlatDiscount();
        given(discountRepository.findByKey(DiscountKeyEnum.FLAT)).willReturn(discount);


        Discount resp = discountService.findByKey(DiscountKeyEnum.FLAT);
        Assertions.assertAll(
                () -> Assertions.assertEquals(discount.getType(), resp.getType()),
                () -> Assertions.assertEquals(discount.getKey(), resp.getKey())
        );

    }
}