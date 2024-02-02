package com.blog.demo.repository;

import com.blog.demo.model.PostFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostFilesRespository extends JpaRepository<PostFile, Integer> {
}
