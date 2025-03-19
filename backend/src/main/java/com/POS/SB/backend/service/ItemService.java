package com.POS.SB.backend.service;

import com.POS.SB.backend.dto.paginated.PaginatedResponseItemDTO;
import com.POS.SB.backend.dto.request.ItemSaveRequestDTO;
import com.POS.SB.backend.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemNameAndStatusBymapStruct(String itemName);

    List<ItemGetResponseDTO> getItemsByActiveStatus(boolean activeState);

    PaginatedResponseItemDTO getItemsByActiveStatusWithPaginated(boolean activeState, int page, int size);
}
