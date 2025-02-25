package com.POS.SB.backend.service.IMPL;

import com.POS.SB.backend.dto.CustomerDTO;
import com.POS.SB.backend.dto.request.CustomerUpdateDTO;

public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerByID(int customerId);
}
