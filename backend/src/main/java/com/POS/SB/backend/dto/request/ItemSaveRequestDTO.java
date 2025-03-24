package com.POS.SB.backend.dto.request;

import com.POS.SB.backend.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ItemSaveRequestDTO {
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private Double balanceQty;
    private Double supplierPrice;
    private Double sellingPrice;

    public Object isActiveState() {
        return null;
    }

    public void setActiveState(Object o) {
    }
}
