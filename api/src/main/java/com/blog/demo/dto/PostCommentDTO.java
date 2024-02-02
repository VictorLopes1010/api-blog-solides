package com.blog.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostCommentDTO {

    private Integer id;

    private Integer postId;

    private String information;

    private Integer usuCreationId;

    private Boolean active;


}
