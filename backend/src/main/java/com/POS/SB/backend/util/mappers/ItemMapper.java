package com.POS.SB.backend.util.mappers;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemGetResponseDTO map(Item item);
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);

    List<ItemGetResponseDTO> ListDTOToPage(Page<Item> items);

    List<ItemGetResponseDTO> pageToList(Page<Item> getAllActiveItemsByPaginated);

}
