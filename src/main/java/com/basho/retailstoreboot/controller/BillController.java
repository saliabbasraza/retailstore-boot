package com.basho.retailstoreboot.controller;

import com.basho.retailstoreboot.entity.Bill;
import com.basho.retailstoreboot.service.BillService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.NotSupportedException;

@RestController
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }


    @PostMapping
    public Bill add(@RequestBody Bill bill) {
        return billService.add(bill);
    }

}
