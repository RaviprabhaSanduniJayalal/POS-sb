package com.POS.SB.backend.dto.paginated;

import com.POS.SB.backend.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    List<ItemGetResponseDTO> list;
    private long dataCount;

    public PaginatedResponseItemDTO(List<ItemGetResponseDTO> itemGetResponseDTOS, int count) {
    }
}
