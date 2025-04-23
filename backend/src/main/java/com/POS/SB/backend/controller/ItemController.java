package com.POS.SB.backend.controller;

import com.POS.SB.backend.dto.paginated.PaginatedResponseItemDTO;
import com.POS.SB.backend.dto.request.ItemSaveRequestDTO;
import com.POS.SB.backend.dto.response.ItemGetResponseDTO;
import com.POS.SB.backend.service.ItemService;
import com.POS.SB.backend.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemservice;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemservice.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message),
                HttpStatus.CREATED
        );
    }
    @GetMapping(
            path="/get-by-name",
            params="name"
    )
    public List<ItemGetResponseDTO> getItemNameAndStatus(@RequestParam (value="name")String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemservice.getItemNameAndStatus(itemName);
        return itemDTOS;

    }

    @GetMapping(
            path="/get-by-name-with-mapstruct",
            params="name"
    )
    public List<ItemGetResponseDTO> getItemNameAndStatusByMapStruct(@RequestParam (value="name")String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemservice.getItemNameAndStatusBymapStruct(itemName);
        return itemDTOS;

    }
    @GetMapping(
            path="/get-all-item-by-status",
            params = {"activeState","page","size"}
    )
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(
            @RequestParam(value = "activeState")boolean activeState,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size") @Max(50) int size
    ){
        PaginatedResponseItemDTO paginatedResponseItemDTO=itemservice.getItemsByActiveStatusWithPaginated(activeState,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path="get-all-active-items-paginated",
            params={"page","size","activeState"}
    )
    public ResponseEntity<StandardResponse> getAllActiveItemsPaginated(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")@Max(50)int size,
            @RequestParam(value="activeState") boolean activeState
    ){
        PaginatedResponseItemDTO paginatedResponseItemDTO=itemservice.getAllActiveItemsPaginated(page,size,activeState);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseItemDTO)
                ,HttpStatus.OK
        );
    }
}
