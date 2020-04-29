package com.basho.retailstoreboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {

    @GetMapping
    String index() {
        return "Welcome to Retail Store Sample build on Springboot";
    }
}

