package com.example.demo.service.Impl;

import com.example.demo.DTO.CouponDTO.CouponCreateDTO;
import com.example.demo.DTO.CouponDTO.CouponResponseDTO;
import com.example.demo.entity.Coupon;
import com.example.demo.repository.CouponRepository;
import com.example.demo.service.CouponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;


    public CouponResponseDTO create(CouponCreateDTO dto) {
        Coupon coupon = new Coupon();
        coupon.setCode(dto.getCode());
        coupon.setDiscount(dto.getDiscount());

        Coupon savedCoupon = couponRepository.save(coupon);
        return mapToResponseDTO(savedCoupon);
    }

    public List<CouponResponseDTO> getAll() {
        return couponRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public CouponResponseDTO update(Long id, CouponCreateDTO dto) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        coupon.setCode(dto.getCode());
        coupon.setDiscount(dto.getDiscount());

        Coupon updatedCoupon = couponRepository.save(coupon);
        return mapToResponseDTO(updatedCoupon);
    }

    public void delete(Long id) {
        if (!couponRepository.existsById(id)) {
            throw new RuntimeException("Coupon not found");
        }
        couponRepository.deleteById(id);
    }

    private CouponResponseDTO mapToResponseDTO(Coupon coupon) {
        CouponResponseDTO dto = new CouponResponseDTO();
        dto.setId(coupon.getId());
        dto.setCode(coupon.getCode());
        dto.setDiscount(coupon.getDiscount());
        return dto;
    }
}
