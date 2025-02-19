package com.POS.SB.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderDetailsSave {
    private String itemName;
    private Double qty;
    private Double amount;
    private int orders;
    private int items;
}
