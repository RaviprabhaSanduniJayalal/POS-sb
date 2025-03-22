package com.POS.SB.backend.service.IMPL;

import com.POS.SB.backend.repo.CustomerRepo;
import com.POS.SB.backend.repo.ItemRepo;
import com.POS.SB.backend.repo.OrderDetailsRepo;
import com.POS.SB.backend.repo.OrderRepo;
import com.POS.SB.backend.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;


}
