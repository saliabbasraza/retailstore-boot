package com.basho.retailstoreboot.service;

import com.basho.retailstoreboot.DiscountKeyEnum;
import com.basho.retailstoreboot.DiscountTypeEnum;
import com.basho.retailstoreboot.entity.Bill;
import com.basho.retailstoreboot.entity.Discount;
import com.basho.retailstoreboot.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final DiscountService discountService;
    private final CustomerService customerService;

    public BillService(BillRepository billRepository, DiscountService discountService, CustomerService customerService) {
        this.billRepository = billRepository;
        this.discountService = discountService;
        this.customerService = customerService;
    }

    public Bill add(Bill bill) {
        bill.setCustomer(customerService.getById(bill.getCustomer().getId()));
        applyDiscount(bill);
        return billRepository.save(bill);
    }

    public Bill applyDiscount(Bill bill) {
        Set<Discount> billDiscounts = new HashSet<>();
        billDiscounts.add(discountService.findByKey(DiscountKeyEnum.FLAT));

        List<Discount> percentageDiscounts = discountService.findAllByType(DiscountTypeEnum.PERCENTAGE);
        for (Discount discount : percentageDiscounts) {
            if (discount.isApplicable(bill)) {
                billDiscounts.add(discount);
                break;
            }
        }

        bill.setDiscounts(billDiscounts);
        bill.setDiscount(bill.getDiscounts().stream().mapToDouble(value -> value.getDiscount(bill)).sum());

        bill.setNetPayable(bill.getTotal() - bill.getDiscount());

        return bill;
    }
}
