package com.blog.demo.service;

import com.blog.demo.dto.PostCommentDTO;
import com.blog.demo.dto.SearchPostCommentDTO;

import java.util.List;

public interface PostCommentService {
    void SavePostComments(List<PostCommentDTO> postCommentsDTOS);

    List<SearchPostCommentDTO> searchPostCommentsByPostId(Integer postId);
}
