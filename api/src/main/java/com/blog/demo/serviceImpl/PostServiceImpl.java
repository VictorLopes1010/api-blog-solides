package com.blog.demo.serviceImpl;

import com.blog.demo.dto.PostAndCommentsDTO;
import com.blog.demo.dto.PostDTO;
import com.blog.demo.dto.SearchPostCommentDTO;
import com.blog.demo.model.Post;
import com.blog.demo.model.User;
import com.blog.demo.repository.PostRepository;
import com.blog.demo.service.PostCommentService;
import com.blog.demo.service.PostFilesService;
import com.blog.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostFilesService postFilesService;

    @Autowired
    PostCommentService postCommentService;

    @Override
    public void savePost(List<MultipartFile> files, PostDTO postDTO){
        Post newPost = new Post();
        if(postDTO.getId() == null){
            newPost.setUsuCriacao(new User(postDTO.getUsuCreationId()));
            newPost.setDataCreation(new Date());
        }else{
            newPost.setId(postDTO.getId());
        }
        newPost.setLink(postDTO.getLink());
        newPost.setActive(postDTO.getActive());
        newPost.setInformation(postDTO.getInformation());
        try {
            newPost = postRepository.saveAndFlush(newPost);
            postFilesService.savePostFiles(files, newPost.getId());
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar Post", e);
        }

    }

    @Override
    public List<PostAndCommentsDTO> searchPostsAndComments() {
        List<PostAndCommentsDTO> postsAndComments = new ArrayList<>();
        List<PostDTO> posts = postRepository.searchPosts().stream().map(PostDTO::new).collect(Collectors.toList());

        for (PostDTO post : posts) {
            PostAndCommentsDTO newPostComment = new PostAndCommentsDTO();
            newPostComment.setInformation(post.getInformation());
            newPostComment.setId(post.getId());
            newPostComment.setUsuCreationId(post.getUsuCreationId());
            newPostComment.setLink(post.getLink());

            newPostComment.setComments(new ArrayList<>());

            List<SearchPostCommentDTO> listComments = postCommentService.searchPostCommentsByPostId(post.getId());

            for (SearchPostCommentDTO comment : listComments) {
                newPostComment.getComments().add(comment);
            }

            postsAndComments.add(newPostComment);
        }

        return postsAndComments;
    }


}
