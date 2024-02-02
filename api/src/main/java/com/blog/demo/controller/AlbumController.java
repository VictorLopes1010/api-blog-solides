package com.blog.demo.controller;

import com.blog.demo.dto.AlbumDTO;
import com.blog.demo.dto.PostDTO;
import com.blog.demo.dto.SearchAlbumDTO;
import com.blog.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @PostMapping("")
    public ResponseEntity saveAlbum(@RequestParam("anexos") List<MultipartFile> files,
                                    @RequestParam("dadosAlbum") AlbumDTO albumDTO) {
        albumService.saveAlbum(files, albumDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<SearchAlbumDTO> searchAlbuns(){
        return albumService.searchAlbuns();
    }

}
