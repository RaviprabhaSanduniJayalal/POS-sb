package com.POS.SB.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customers;
    private Date date;
    private List<RequestOrderDetailsSave> orderDetails;
    private Double total;
}
