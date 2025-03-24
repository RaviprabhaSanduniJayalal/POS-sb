package com.POS.SB.backend.service.IMPL;

import com.POS.SB.backend.dto.paginated.PaginatedResponseOrderDetails;
import com.POS.SB.backend.dto.queryInterfaces.OrderDetailsInterface;
import com.POS.SB.backend.dto.request.RequestOrderSaveDTO;
import com.POS.SB.backend.dto.response.ResponseOrderDetailsDTO;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size) {
        List<OrderDetailsInterface> orderDetailsDTOS=orderRepo.getAllOrderDetails(status, PageRequest.of(page,size) );

        List<ResponseOrderDetailsDTO> list=new ArrayList<>();
        for(OrderDetailsInterface o:orderDetailsDTOS){
            ResponseOrderDetailsDTO r=new ResponseOrderDetailsDTO(
                    o.getCustomerName(),
                    o.getCustomerAddress(),
                    o.getContactNumber(),
                    o.getDate(),
                    o.getTotal()
            );
            list.add(r);

        }
        PaginatedResponseOrderDetails paginatedResponseOrderDetails=new PaginatedResponseOrderDetails(
                list,
                orderRepo.countAllOrderDetails(status)
        );
        return paginatedResponseOrderDetails;
    }

}
