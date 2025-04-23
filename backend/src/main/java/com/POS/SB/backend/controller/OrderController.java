package com.POS.SB.backend.controller;


import com.POS.SB.backend.dto.paginated.PaginatedResponseOrderDetails;
import com.POS.SB.backend.dto.request.RequestOrderSaveDTO;
import com.POS.SB.backend.service.OrderService;
import com.POS.SB.backend.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        String id = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+" ",2),
                HttpStatus.CREATED
        );
    }
    @GetMapping(
            params = {"stateType","page","size"},
            path={"/get-order-details"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")@Max(50)int size

    ){
        PaginatedResponseOrderDetails p=null;
        if(stateType.equalsIgnoreCase("active")|stateType.equalsIgnoreCase("inactive")){
            boolean status=stateType.equalsIgnoreCase("active")?true:false;
            p=orderService.getAllOrderDetails(status,page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successful",p),
                HttpStatus.OK
        );

    }
}
