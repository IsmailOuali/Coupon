package com.example.demo.controller;

import com.example.demo.DTO.CommentDTO.CommentCreateDTO;
import com.example.demo.DTO.CommentDTO.CommentResponseDTO;
import com.example.demo.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentResponseDTO> create(@RequestBody CommentCreateDTO dto) {
        CommentResponseDTO response = commentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDTO>> getAll() {
        List<CommentResponseDTO> response = commentService.getAll();
        return ResponseEntity.ok(response);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> update(
            @PathVariable Long id,
            @RequestBody CommentCreateDTO dto) {
        CommentResponseDTO response = commentService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
