package com.example.zerone.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @GetMapping
    public List<String> getCustomers(){
        return Arrays.asList("Kiran", "Vinay");
    }
}