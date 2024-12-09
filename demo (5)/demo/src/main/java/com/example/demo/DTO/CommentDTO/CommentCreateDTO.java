package com.example.demo.DTO.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateDTO {

    private Long id;
    private String text;
    private String author;

}