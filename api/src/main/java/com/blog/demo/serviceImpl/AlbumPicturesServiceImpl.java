package com.blog.demo.serviceImpl;

import com.blog.demo.model.Album;
import com.blog.demo.model.AlbumPictures;
import com.blog.demo.model.Post;
import com.blog.demo.model.PostFile;
import com.blog.demo.service.AlbumPicturesService;
import com.blog.demo.utils.MethodsUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AlbumPicturesServiceImpl implements AlbumPicturesService {

    @Value("${img.path}")
    private String filesPath;

    @Override
    public void saveAlbumPictures(List<MultipartFile> files, Integer albumId){
        for (MultipartFile file : files) {
            try {
                MethodsUtils.fileUpload(filesPath, "AlbumPictures", file);
                AlbumPictures newAlbumPictureRegister = new AlbumPictures();
                newAlbumPictureRegister.setIdAlbum(new Album(albumId));
            }catch (Exception e){
                throw new RuntimeException("Erro ao salvar Fotos", e);
            }
        }

    }
}
