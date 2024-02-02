package com.blog.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AlbumPicturesService {
    void saveAlbumPictures(List<MultipartFile> files, Integer albumId);
}
