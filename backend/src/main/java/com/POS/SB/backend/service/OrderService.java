package com.POS.SB.backend.service;

import com.POS.SB.backend.dto.paginated.PaginatedResponseOrderDetails;
import com.POS.SB.backend.dto.request.RequestOrderSaveDTO;
import jakarta.transaction.Transactional;

public interface OrderService {

    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);


    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size);
}
