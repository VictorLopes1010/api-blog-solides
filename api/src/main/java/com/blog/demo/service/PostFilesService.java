package com.blog.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostFilesService {
    void savePostFiles(List<MultipartFile> files, Integer postId);
}
