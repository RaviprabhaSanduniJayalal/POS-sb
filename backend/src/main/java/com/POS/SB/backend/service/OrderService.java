package com.POS.SB.backend.service;

import com.POS.SB.backend.dto.request.RequestOrderSaveDTO;
import jakarta.transaction.Transactional;

public interface OrderService {
    @Transactional
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    @Transactional
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
