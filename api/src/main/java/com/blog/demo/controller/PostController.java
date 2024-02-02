package com.blog.demo.controller;

import com.blog.demo.dto.PostAndCommentsDTO;
import com.blog.demo.dto.PostCommentDTO;
import com.blog.demo.dto.PostDTO;
import com.blog.demo.service.PostCommentService;
import com.blog.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostCommentService postCommentService;

    @PostMapping("")
    public ResponseEntity savePost(@RequestParam("anexos") List<MultipartFile> files,
                                         @RequestParam("dadosPost") PostDTO postDTO) {
        postService.savePost(files, postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/comments")
    public ResponseEntity saveComments(@RequestBody List<PostCommentDTO> postCommentsDTO){
        postCommentService.SavePostComments(postCommentsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("")
    public List<PostAndCommentsDTO> searchPostsAndComments(){
        return postService.searchPostsAndComments();
    }

}
