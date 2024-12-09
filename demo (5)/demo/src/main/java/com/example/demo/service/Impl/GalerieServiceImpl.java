package com.example.demo.service.Impl;

import com.example.demo.DTO.GalerieDTO.GalerieCreateDTO;
import com.example.demo.DTO.GalerieDTO.GalerieResponseDTO;
import com.example.demo.entity.Galerie;
import com.example.demo.repository.GalerieRepository;
import com.example.demo.service.GalerieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GalerieServiceImpl implements GalerieService {

    private final GalerieRepository galerieRepository;



    public GalerieResponseDTO create(GalerieCreateDTO dto) {
        Galerie galerie = new Galerie();
        galerie.setTitle(dto.getTitle());
        galerie.setImageUrl(dto.getImageUrl());

        Galerie savedGalerie = galerieRepository.save(galerie);
        return mapToResponseDTO(savedGalerie);
    }

    public List<GalerieResponseDTO> getAll() {
        return galerieRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public GalerieResponseDTO update(Long id, GalerieCreateDTO dto) {
        Galerie galerie = galerieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Galerie not found"));

        galerie.setTitle(dto.getTitle());
        galerie.setImageUrl(dto.getImageUrl());

        Galerie updatedGalerie = galerieRepository.save(galerie);
        return mapToResponseDTO(updatedGalerie);
    }

    public void delete(Long id) {
        if (!galerieRepository.existsById(id)) {
            throw new RuntimeException("Galerie not found");
        }
        galerieRepository.deleteById(id);
    }

    private GalerieResponseDTO mapToResponseDTO(Galerie galerie) {
        GalerieResponseDTO dto = new GalerieResponseDTO();
        dto.setId(galerie.getId());
        dto.setTitle(galerie.getTitle());
        dto.setImageUrl(galerie.getImageUrl());
        return dto;
    }
}

