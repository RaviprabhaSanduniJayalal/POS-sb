package com.POS.SB.backend.service.IMPL;

import com.POS.SB.backend.dto.CustomerDTO;
import com.POS.SB.backend.entity.Customer;
import com.POS.SB.backend.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getCustomerID(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getSalary(),
                customerDTO.getNIC(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }
}
