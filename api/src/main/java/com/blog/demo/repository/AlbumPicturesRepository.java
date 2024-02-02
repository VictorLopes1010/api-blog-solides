package com.blog.demo.repository;

import com.blog.demo.model.AlbumPictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumPicturesRepository extends JpaRepository<AlbumPictures, Integer> {
}
