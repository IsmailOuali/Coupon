package com.example.demo.DTO.GalerieDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GalerieCreateDTO {
    private String title;
    private String imageUrl;
}
