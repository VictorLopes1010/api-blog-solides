package com.blog.demo.repository;

import com.blog.demo.dto.SearchAlbumDTO;
import com.blog.demo.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query(value = "SELECT al.id as id, al.name as name, u.name as creatorName FROM albuns al\n" +
            "JOIN users u on u.id = al.usu_creation", nativeQuery = true)
    List<SearchAlbumDTO.SearchAlbumInterfaceDTO> searchAlbuns();
}
