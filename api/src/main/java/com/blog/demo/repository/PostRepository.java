package com.blog.demo.repository;

import com.blog.demo.dto.PostDTO;
import com.blog.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "select p.id as id, p.information as information, p.link as link, p.usu_creation as usuCreationId from posts p where p.active = true",nativeQuery = true)
    List<PostDTO.PostInterfaceDTO> searchPosts();

}
