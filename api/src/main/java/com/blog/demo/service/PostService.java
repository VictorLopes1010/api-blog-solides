package com.blog.demo.service;

import com.blog.demo.dto.PostAndCommentsDTO;
import com.blog.demo.dto.PostCommentDTO;
import com.blog.demo.dto.PostDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    void savePost(List<MultipartFile> files, PostDTO postDTO);

    List<PostAndCommentsDTO> searchPostsAndComments();
}
