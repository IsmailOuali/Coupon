package com.example.demo.DTO.CouponDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponCreateDTO {
    private String code;
    private double discount;
}
