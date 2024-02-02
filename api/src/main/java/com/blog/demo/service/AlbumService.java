package com.blog.demo.service;

import com.blog.demo.dto.AlbumDTO;
import com.blog.demo.dto.SearchAlbumDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AlbumService {
    void saveAlbum(List<MultipartFile> files, AlbumDTO albumDTO);

    List<SearchAlbumDTO> searchAlbuns();
}
