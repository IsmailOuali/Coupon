package com.example.demo.controller;

import com.example.demo.DTO.GalerieDTO.GalerieCreateDTO;
import com.example.demo.DTO.GalerieDTO.GalerieResponseDTO;
import com.example.demo.service.GalerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/galeries")
public class GalerieController {

    private final GalerieService galerieService;

    public GalerieController(GalerieService galerieService) {
        this.galerieService = galerieService;
    }


    @PostMapping
    public ResponseEntity<GalerieResponseDTO> create(@RequestBody GalerieCreateDTO dto) {
        GalerieResponseDTO response = galerieService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<GalerieResponseDTO>> getAll() {
        List<GalerieResponseDTO> response = galerieService.getAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GalerieResponseDTO> update(
            @PathVariable Long id,
            @RequestBody GalerieCreateDTO dto) {
        GalerieResponseDTO response = galerieService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        galerieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

