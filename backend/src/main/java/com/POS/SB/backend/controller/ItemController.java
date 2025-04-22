package com.POS.SB.backend.controller;

import com.POS.SB.backend.dto.request.ItemSaveRequestDTO;
import com.POS.SB.backend.service.ItemService;
import com.POS.SB.backend.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
