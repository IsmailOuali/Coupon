package com.example.demo.controller;

import com.example.demo.DTO.CouponDTO.CouponCreateDTO;
import com.example.demo.DTO.CouponDTO.CouponResponseDTO;
import com.example.demo.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    public ResponseEntity<CouponResponseDTO> create(@RequestBody CouponCreateDTO dto) {
        CouponResponseDTO response = couponService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CouponResponseDTO>> getAll() {
        List<CouponResponseDTO> response = couponService.getAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouponResponseDTO> update(
            @PathVariable Long id,
            @RequestBody CouponCreateDTO dto) {
        CouponResponseDTO response = couponService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        couponService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

