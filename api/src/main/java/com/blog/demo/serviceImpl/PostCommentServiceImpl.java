package com.blog.demo.serviceImpl;

import com.blog.demo.dto.PostCommentDTO;
import com.blog.demo.dto.SearchPostCommentDTO;
import com.blog.demo.model.Post;
import com.blog.demo.model.PostComment;
import com.blog.demo.model.User;
import com.blog.demo.repository.PostCommentRepository;
import com.blog.demo.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostCommentServiceImpl implements PostCommentService {

    @Autowired
    PostCommentRepository postCommentRepository;

    @Override
    public void SavePostComments(List<PostCommentDTO> postCommentsDTOS){
        for (PostCommentDTO comment : postCommentsDTOS) {
            PostComment newPostComment = new PostComment();
            if(comment.getId() == null){
                newPostComment.setDateCreation(new Date());
                newPostComment.setUsuCriacao(new User(comment.getUsuCreationId()));
            }else{
                newPostComment.setId(comment.getId());
            }
            newPostComment.setInformation(comment.getInformation());
            newPostComment.setPost(new Post(comment.getPostId()));
            newPostComment.setActive(comment.getActive());
            try{
                postCommentRepository.saveAndFlush(newPostComment);
            }catch (Exception e){
                throw new RuntimeException("Erro ao salvar Comentário", e);
            }

        }
    }

    @Override
    public List<SearchPostCommentDTO> searchPostCommentsByPostId(Integer postId){
        return postCommentRepository.searchPostComments(postId).stream().map(SearchPostCommentDTO::new).collect(Collectors.toList());
    }

}
