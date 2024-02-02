package com.blog.demo.repository;

import com.blog.demo.dto.SearchPostCommentDTO;
import com.blog.demo.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Integer> {

    @Query(value = "select pc.information as information, u.name as creatorName \n" +
            "FROM post_comments pc \n" +
            "JOIN users u on u.id = pc.usu_creation\n" +
            "where pc.id_post = :idPost and active = true", nativeQuery = true)
    public List<SearchPostCommentDTO.SearchPostCommentInterfaceDTO> searchPostComments(Integer idPost);
}
