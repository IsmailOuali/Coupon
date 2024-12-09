package com.example.demo.service;

import com.example.demo.DTO.CommentDTO.CommentCreateDTO;
import com.example.demo.DTO.CommentDTO.CommentResponseDTO;
import com.example.demo.entity.Comment;

import java.util.List;

public interface CommentService {
    CommentResponseDTO create(CommentCreateDTO dto);
    void delete(Long id);
    CommentResponseDTO update(Long id, CommentCreateDTO dto);
    List<CommentResponseDTO> getAll();
}
