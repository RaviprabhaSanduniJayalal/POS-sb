package com.POS.SB.backend.dto.queryInterfaces;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {
    String getCustomerName();
    String getCustomerAddress();
    ArrayList getContactNumber();
    Date getDate();
    Double getTotal();
}
