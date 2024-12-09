package com.example.demo.DTO.CouponDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponResponseDTO {
    private Long id;
    private String code;
    private double discount;
}