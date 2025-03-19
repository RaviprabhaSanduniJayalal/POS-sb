package com.POS.SB.backend.service;

import com.POS.SB.backend.dto.request.ItemSaveRequestDTO;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
