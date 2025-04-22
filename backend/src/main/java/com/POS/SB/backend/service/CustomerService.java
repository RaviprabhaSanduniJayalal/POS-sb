package com.POS.SB.backend.service;

import com.POS.SB.backend.dto.CustomerDTO;
import com.POS.SB.backend.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);



    CustomerDTO getCustomerByID(int customerId);

    List<CustomerDTO> getAllCustomers();

    List<CustomerDTO> getAllCustomersByActiveStatus(boolean activestate);

    String deletecustomer(int customerId);
}
