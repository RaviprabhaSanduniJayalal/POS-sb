package com.POS.SB.backend.controller;

import com.POS.SB.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/Customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;


}

