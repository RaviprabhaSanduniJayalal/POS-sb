package com.POS.SB.backend.dto.paginated;

import com.POS.SB.backend.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetails {
    private List<ResponseOrderDetailsDTO> list;
    private long dataCount;

    public PaginatedResponseOrderDetails(List<ResponseOrderDetailsDTO> list, long dataCount) {
    }
}
