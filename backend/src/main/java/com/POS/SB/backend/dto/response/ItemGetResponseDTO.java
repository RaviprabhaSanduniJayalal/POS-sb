package com.POS.SB.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private Double balanceQty;
    private Double supplierPrice;
    private Double sellingPrice;
}
