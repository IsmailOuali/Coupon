package com.example.demo.service;

import com.example.demo.DTO.GalerieDTO.GalerieCreateDTO;
import com.example.demo.DTO.GalerieDTO.GalerieResponseDTO;

import java.util.List;

public interface GalerieService {
    void delete(Long id);
    GalerieResponseDTO update(Long id, GalerieCreateDTO dto);
    List<GalerieResponseDTO> getAll();
    GalerieResponseDTO create(GalerieCreateDTO dto);
}
