package com.blog.demo.serviceImpl;

import com.blog.demo.model.Post;
import com.blog.demo.model.PostFile;
import com.blog.demo.service.PostFilesService;
import com.blog.demo.utils.MethodsUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PostFilesServiceImpl implements PostFilesService {


    @Value("${img.path}")
    private String filesPath;

    @Override
    public void savePostFiles(List<MultipartFile> files, Integer postId){
        for (MultipartFile file : files) {
            try {
                MethodsUtils.fileUpload(filesPath, "PostFiles", file);
                PostFile newPostFileRegister = new PostFile();
                newPostFileRegister.setPost(new Post(postId));
            }catch (Exception e){
                throw new RuntimeException("Erro ao salvar arquivo", e);
            }
        }

    }

}
