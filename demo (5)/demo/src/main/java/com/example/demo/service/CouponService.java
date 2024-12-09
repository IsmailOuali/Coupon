package com.example.demo.service;

import com.example.demo.DTO.CouponDTO.CouponCreateDTO;
import com.example.demo.DTO.CouponDTO.CouponResponseDTO;

import java.util.List;

public interface CouponService {
    void delete(Long id);
    CouponResponseDTO update(Long id, CouponCreateDTO dto);
    CouponResponseDTO create(CouponCreateDTO dto);
    List<CouponResponseDTO> getAll();
}
