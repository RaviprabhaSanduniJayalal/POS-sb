package com.POS.SB.backend.service.IMPL;

import com.POS.SB.backend.dto.request.RequestOrderSaveDTO;
import com.POS.SB.backend.entity.Order;
import com.POS.SB.backend.entity.OrderDetails;
import com.POS.SB.backend.repo.CustomerRepo;
import com.POS.SB.backend.repo.ItemRepo;
import com.POS.SB.backend.repo.OrderDetailsRepo;
import com.POS.SB.backend.repo.OrderRepo;
import com.POS.SB.backend.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Transactional
    @Override
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
                customerRepo.getById(requestOrderSaveDTO.getCustomers()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(order);

        if(orderRepo.existsById(order.getOrderId())){

            List<OrderDetails> orderDetails=modelMapper.map(requestOrderSaveDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){}.getType());

            for(int i=0; i<orderDetails.size(); i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if(orderDetails.size()>0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "saved successfully";
        }
        return " error";
    }

}
