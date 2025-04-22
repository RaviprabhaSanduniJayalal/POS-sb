package com.POS.SB.backend.controller;

import com.POS.SB.backend.dto.CustomerDTO;
import com.POS.SB.backend.dto.request.CustomerUpdateDTO;
import com.POS.SB.backend.service.CustomerService;
import com.POS.SB.backend.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
    }
    @GetMapping(
            path="/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerByID(@RequestParam(value = "id") int customerId) {
        CustomerDTO customerDTO=customerService.getCustomerByID(customerId);
        return customerDTO;
    }
    @GetMapping(
            path="/get-all-customers"
    )
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> allCustomers = (List<CustomerDTO>) customerService.getAllCustomers();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allCustomers),
                HttpStatus.OK
        );
    }

    @DeleteMapping(
            path="delete-customer/{id}"
    )
    public String deleteCustomer(@RequestParam(value = "id") int customerId) {
        String deleted=customerService.deletecustomer(customerId);
        return deleted;
    }

    @GetMapping(path="/get-all-customers-by-active-status/{status}")
    public List<CustomerDTO> getAllCustomersByActiveStatus(@PathVariable(value = "status") boolean activestate) {

        List<CustomerDTO> allCustomers=customerService.getAllCustomersByActiveStatus(activestate);
        return allCustomers;

    }
}

