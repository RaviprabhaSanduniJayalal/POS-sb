package com.POS.SB.backend.service.IMPL;

import com.POS.SB.backend.dto.CustomerDTO;
import com.POS.SB.backend.dto.request.CustomerUpdateDTO;
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

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO){
        if(customerRepo.existsById(customerUpdateDTO.getCustomerID())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerID());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setSalary(customerUpdateDTO.getSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName()+" has been updated successfully";
        }
        else{
            throw new RuntimeException("No data found for id " + customerUpdateDTO.getCustomerID());
        }
    }

}
