package com.blog.demo.serviceImpl;

import com.blog.demo.dto.AlbumDTO;
import com.blog.demo.dto.SearchAlbumDTO;
import com.blog.demo.model.Album;
import com.blog.demo.model.User;
import com.blog.demo.repository.AlbumRepository;
import com.blog.demo.service.AlbumPicturesService;
import com.blog.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumPicturesService albumPicturesService;

    @Override
    public void saveAlbum(List<MultipartFile> files, AlbumDTO albumDTO){
        Album newAlbum = new Album();
        if(albumDTO.getId() == null){
            newAlbum.setUsuCriacao(new User(albumDTO.getUsuCreationId()));
            newAlbum.setDataCreation(new Date());
        }else{
            newAlbum.setId(albumDTO.getId());
        }
        newAlbum.setActive(albumDTO.getActive());
        newAlbum.setName(albumDTO.getName());
        try {
            newAlbum = albumRepository.saveAndFlush(newAlbum);
            albumPicturesService.saveAlbumPictures(files, newAlbum.getId());
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar Album", e);
        }

    }

    @Override
    public List<SearchAlbumDTO> searchAlbuns(){
        return albumRepository.searchAlbuns().stream().map(SearchAlbumDTO :: new).collect(Collectors.toList());
    }
}
