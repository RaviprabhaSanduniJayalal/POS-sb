package com.POS.SB.backend.controller;

import com.POS.SB.backend.dto.CustomerDTO;
import com.POS.SB.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        // CustomerServiceIMPL customerServiceIMPL=new CustomerServiceIMPL();
        //customerServiceIMPL.saveCustomer(customerDTO);

        customerService.saveCustomer(customerDTO);
        return "customer saved successfully ";
    }

}

