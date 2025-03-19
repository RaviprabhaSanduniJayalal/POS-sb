package com.POS.SB.backend.service.IMPL;

import com.POS.SB.backend.dto.paginated.PaginatedResponseItemDTO;
import com.POS.SB.backend.dto.request.ItemSaveRequestDTO;
import com.POS.SB.backend.dto.response.ItemGetResponseDTO;
import com.POS.SB.backend.entity.Item;
import com.POS.SB.backend.exception.NotFoundException;
import com.POS.SB.backend.repo.ItemRepo;
import com.POS.SB.backend.service.ItemService;
import com.POS.SB.backend.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        /*Item item = new Item(
                1,
                itemSaveRequestDTO.getItemName(),
                itemSaveRequestDTO.getMeasuringUnitType(),
                itemSaveRequestDTO.getBalanceQty(),
                itemSaveRequestDTO.getSupplierPrice(),
                itemSaveRequestDTO.getSellingPrice(),
                true


        );
        itemRepo.save(item);
        return item.getItemName();
*/
        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);

        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId()+ " saved successfully";
        }
        else{
            throw new DuplicateKeyException("Item already exists");
        }





    }
    @Override
    public List<ItemGetResponseDTO> getItemNameAndStatusBymapStruct(String itemName) {
        boolean activeState=true;
        List<Item> items=itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,activeState);

        if(items.size()>0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS =itemMapper.entityListToDtoList(items);
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item is not active");
        }
    }


    @Override
    public List<ItemGetResponseDTO> getItemsByActiveStatus(boolean activeState) {
        List<Item> items=itemRepo.findAllByActiveStateEquals(activeState);

        if(items.size()>0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS =itemMapper.entityListToDtoList(items);
            return itemGetResponseDTOS;
        }else {
            throw new NotFoundException("Item is not active");
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemsByActiveStatusWithPaginated(boolean activeState, int page, int size) {
        Page<Item> items=itemRepo.findAllByActiveStateEquals(activeState, PageRequest.of(page,size));
        int count=itemRepo.countAllByActiveStateEquals(activeState);
        if(items.getSize()<1){
            throw new NotFoundException("No Data Found");
        }
        PaginatedResponseItemDTO paginatedResponseItemDTOS = new PaginatedResponseItemDTO(
                itemMapper.ListDTOToPage(items),
                count
        );
        return paginatedResponseItemDTOS;

    }
}
