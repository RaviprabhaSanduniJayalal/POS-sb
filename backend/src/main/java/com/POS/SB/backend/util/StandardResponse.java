package com.POS.SB.backend.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}

