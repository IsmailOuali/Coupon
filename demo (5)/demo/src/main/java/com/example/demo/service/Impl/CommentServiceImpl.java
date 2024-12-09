package com.example.demo.service.Impl;

import com.example.demo.DTO.CommentDTO.CommentCreateDTO;
import com.example.demo.DTO.CommentDTO.CommentResponseDTO;
import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

        @Autowired
        private final CommentRepository commentRepository;

        @Override
    public CommentResponseDTO create(CommentCreateDTO dto) {
            Comment comment = new Comment();
            comment.setText(dto.getText());
            comment.setAuthor(dto.getAuthor());

            Comment savedComment = commentRepository.save(comment);
            return mapToResponseDTO(savedComment);
        }

        @Override
    public List<CommentResponseDTO> getAll() {
        return commentRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    // Update
    @Override
    public CommentResponseDTO update(Long id, CommentCreateDTO dto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setText(dto.getText());
        comment.setAuthor(dto.getAuthor());

        Comment updatedComment = commentRepository.save(comment);
        return mapToResponseDTO(updatedComment);
    }

    // Delete

    @Override
    public void delete(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new RuntimeException("Comment not found");
        }
        commentRepository.deleteById(id);
    }

        private CommentResponseDTO mapToResponseDTO(Comment comment) {
            CommentResponseDTO dto = new CommentResponseDTO();
            dto.setId(comment.getId());
            dto.setText(comment.getText());
            dto.setAuthor(comment.getAuthor());
            return dto;
        }
    }

