package com.basho.retailstoreboot.repository;

import com.basho.retailstoreboot.DiscountKeyEnum;
import com.basho.retailstoreboot.entity.Discount;
import com.basho.retailstoreboot.entity.FlatDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class DiscountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DiscountRepository discountRepository;

    @Test
    public void findByKey_ShouldReturnFlatDiscount() {
        Discount discount = discountRepository.findByKey(DiscountKeyEnum.FLAT);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(discount.getId()),
                () -> Assertions.assertEquals(DiscountKeyEnum.FLAT, discount.getKey()),
                () -> Assertions.assertEquals(FlatDiscount.class, discount.getClass())
        );
    }


}