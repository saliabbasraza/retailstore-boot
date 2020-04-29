package com.basho.retailstoreboot.controller;

import com.basho.retailstoreboot.entity.Bill;
import com.basho.retailstoreboot.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ITBillControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void whenOldCustomer_createDiscount_ShouldReturn_StandardPlusLoyaltyDiscount() {

        Customer customer = new Customer();
        customer.setId(1l);

        Bill billDto = new Bill();
        billDto.setGroceryTotal(100d);
        billDto.setNonGroceryTotal(100d);
        billDto.setCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());

        HttpEntity<Bill> request = new HttpEntity<>(billDto, headers);

        ResponseEntity<Bill> resp = restTemplate.postForEntity("/bill", request, Bill.class);
        Bill billResp = resp.getBody();

        Assertions.assertAll(
                () -> Assertions.assertEquals(HttpStatus.OK, resp.getStatusCode()),
                () -> Assertions.assertNotNull(billResp.getId()),
                () -> Assertions.assertEquals(15, billResp.getDiscount()),
                () -> Assertions.assertEquals(185, billResp.getNetPayable())
        );
    }

    @Test
    void whenEmployeeCustomer_createDiscount_ShouldReturn_StandardPlusEmployeeDiscount() {

        Customer customer = new Customer();
        customer.setId(3l);

        Bill billDto = new Bill();
        billDto.setGroceryTotal(100d);
        billDto.setNonGroceryTotal(100d);
        billDto.setCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());

        HttpEntity<Bill> request = new HttpEntity<>(billDto, headers);

        ResponseEntity<Bill> resp = restTemplate.postForEntity("/bill", request, Bill.class);
        Bill billResp = resp.getBody();

        Assertions.assertAll(
                () -> Assertions.assertEquals(HttpStatus.OK, resp.getStatusCode()),
                () -> Assertions.assertNotNull(billResp.getId()),
                () -> Assertions.assertEquals(40, billResp.getDiscount()),
                () -> Assertions.assertEquals(160, billResp.getNetPayable())
        );
    }
}